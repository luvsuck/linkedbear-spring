package com.luvsic;

import com.luvsic.dao.DemoDao;
import com.luvsic.dao.impl.DemoDaoImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: zyy
 * @Date: 2024/6/19 15:56
 * @Version:
 * @Description: 静态工厂 提供不同厂家数据库的ao的产出
 */
public class BeanFactory {
    //1.直接通过new方式获取实例 强耦合
    public static DemoDao getDemoDao() {
//        return new DemoOracleDaoImpl();
        return new DemoDaoImpl();//这里直接用new的方式 存在强耦合 文章里是删除该文件来模拟强耦合问题
    }

    //2. 通过反射 运行时获取

    /**
     * 为了避免直接通过new类导致的强耦合问题
     * 这里通过反射来获取实例
     *
     * @return
     */
    public static DemoDao getDemoDaoByReflect() {

        //这里通过反射来实例化，可以避免由于诸如:类不存在导致的编译期错误，这里反射出错属于运行时错误，相当于减弱了对
        //DemoDaoImpl的依赖，也当作为"弱依赖"
        try {
            DemoDao dao = (DemoDao) Class.forName("com.luvsic.dao.impl.DemoOracleDaoImpl").newInstance();
            return dao;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //3. 把类的完全限定名写在配置文件里 独取出来来加载反射获取
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory.properties"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化beanFactory读取properties失败," + e.getMessage());
        }
    }

    //3.1 提供获取对应dao的方法
    public static DemoDao getDemoDaoFromProperty() {
        String beanName = "demoDao";
        try {
            Class<?> clazz = Class.forName(properties.getProperty(beanName));
            return (DemoDao) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    //3.2 进一步抽象，直接按类在配置里的属性名获取对应的对象
    public static Object getBean(String beanName) {
        try {
            Class<?> clazz = Class.forName(properties.getProperty(beanName));
            return clazz.newInstance();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    //3.3 为了解决多次获取bean导致重复开辟内存的问题 引入缓存来解决
    private static Map<String, Object> beanMap = new HashMap<>();

    /**
     * 获取单例bean
     * 双重检查锁确保单例
     *
     * @param beanName
     * @return
     */
    public static Object getSingleBean(String beanName) {
        if (!beanMap.containsKey(beanName)) {
            synchronized (BeanFactory.class) {
                if (!beanMap.containsKey(beanName)) {
                    try {
                        Class<?> clazz = Class.forName(properties.getProperty(beanName));
                        Object bean = clazz.newInstance();
                        beanMap.put(beanName, bean);
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return beanMap.get(beanName);
    }

}
