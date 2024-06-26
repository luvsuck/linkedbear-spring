package com.luvsic.ioc;

import com.luvsic.ioc.bean.Person;
import com.luvsic.ioc.dao.SqlDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ioc测试类 演示bean的查找的几种方法
 * inversion of control 控制反转
 *
 * @Author: ${USER}
 * @Date: $DATE ${TIME}
 * @Version:
 * @Description: 提供几个方法演示ioc控制反转的思想
 */
@Slf4j
public class IOCTest {
    public static void main(String[] args) {
        getBeanByName();
        getBeanByType();
    }

    /**
     * 读取quickstart_p2_case1 通过bean名称获取bean
     * <bean id="person" class="com.luvsic.ioc.bean.Person"/>
     * 1. 读取xml里的bean 强转为具体对象
     */
    public static void getBeanByName() {
        //0. 通过spring提供的xml应用上下文加载resources下的xml资源文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic_dl/quickstart_p2_case1.xml");

        //1. 读取xml里的bean 强转为具体对象
        Person person = (Person) context.getBean("person");
        log.info("get bean by name:{}", person);
    }

    /**
     * 读取quickstart_p2_case2.xml
     * 1. 通过bean的类型获取bean
     * <bean class="com.luvsic.ioc.bean.Person"/>
     * 2. 也可以指定接口实现类来获取子接口bean，接收参数用子接口
     */
    public static void getBeanByType() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic_dl/quickstart_p2_case2.xml");
        Person person = context.getBean(Person.class);
        log.info("get bean by type:{}", person);

        SqlDao sqlDao = context.getBean(SqlDao.class);
        log.info("MysqlDao:{}", sqlDao.findAll());
    }
}