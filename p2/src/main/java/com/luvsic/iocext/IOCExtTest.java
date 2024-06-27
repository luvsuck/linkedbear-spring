package com.luvsic.iocext;

import com.luvsic.iocext.anno.ColorAnno;
import com.luvsic.iocext.bean.Yellow;
import com.luvsic.iocext.dao.SqlDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Author: zyy
 * @Date: 2024/6/26 17:39
 * @Version:
 * @Description:
 */
@Slf4j
public class IOCExtTest {
    public static void main(String[] args) {
        getBeansByType();
        System.out.println("--------------------");
        getBeanByAnnotation();
        System.out.println("--------------------");
        getBeanDefinitionNames();
        System.out.println("--------------------");
        lazyLookup();
    }

    static void getBeansByType() {
        //这里springContext版本为5.28，因此直接就可以通过 getBeansOfType来获取 beanMap
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic_dl/quickstart_p2_case4.xml");
//        Map<String, SqlDao> beans = context.getBeansOfType(SqlDao.class);
//        beans.forEach((k, v) -> {
//            log.info("{}:{}", k, v);
//        });

        //这里模拟老版本SpringContext，没有提供ClassPathXmlApplicationContext的getBeansOfType方法的情况
        ApplicationContext context = new ClassPathXmlApplicationContext("basic_dl/quickstart_p2_case4.xml");
        Map<String, SqlDao> beanMap = context.getBeansOfType(SqlDao.class);
        beanMap.forEach((k, v) -> {
            log.info("{}:{}", k, v);
        });
    }

    static void getBeanByAnnotation() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic_dl/quickstart_p2_case5.xml");
        Map<String, Object> beans = context.getBeansWithAnnotation(ColorAnno.class);
        beans.forEach((k, v) -> {
            log.info("{}:{}", k, v);
        });
        ColorAnno red = context.findAnnotationOnBean("blue", ColorAnno.class);
        log.info("anno:{}", red);
    }

    /**
     * 获取容器中所有bean名称
     */
    static void getBeanDefinitionNames() {
        //把五个配置全加载进来
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic_dl/quickstart_p2_case1.xml",
                "basic_dl/quickstart_p2_case2.xml",
                "basic_dl/quickstart_p2_case3.xml",
                "basic_dl/quickstart_p2_case4.xml",
                "basic_dl/quickstart_p2_case5.xml");

        String[] definitionNames = context.getBeanDefinitionNames();
        //可以看到其输出以后直接beanId，也有完全限定的类，这种是byType的情况打印的
        for (int i = 0; i < definitionNames.length; i++) {
            log.info("definitionName[{}]:{}", i, definitionNames[i]);
        }
    }

    static void lazyLookup() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic_dl/quickstart_p2_case5.xml");
        Yellow yellow;
        //1.假如xml里没有配置相应的yellow bean，则直接getBean会报错，只能用try、catch在catch中完成实例化
        try {
            yellow = context.getBean(Yellow.class);
        } catch (NoSuchBeanDefinitionException e) {
            yellow = new Yellow();
        }
        log.info("yellowBean1:{}", yellow);

        //2. 通过containsBean来判断是否包含指定名称的bean
        yellow = context.containsBean("yellow") ? (Yellow) context.getBean("yellow") : new Yellow();
        log.info("yellowBean2:{}", yellow);

        //3. 获取bean的provider，提供了惰性查找的功能
        ObjectProvider<Yellow> yellowProvider = context.getBeanProvider(Yellow.class);

        //直接使用getObject 相当于就是getBean，由于没有在xml里配置该bean会导致报错
        //通过ifAvailable方法，接受一个Supplier来提供未找到bean后返回一个默认实现
        yellow = yellowProvider.getIfAvailable(Yellow::new);
        log.info("yellowBean3{}", yellow);

        //ifAvailable 如果可用的话，执行consumer
        yellowProvider.ifAvailable(bean -> log.info("yellowBean4{}", bean));
    }
}
