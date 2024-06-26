package com.luvsic.di;

import com.luvsic.di.bean.Monkey;
import com.luvsic.di.bean.Zoo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * di测试类 演示依赖注入的测试类
 * dependency injection 依赖注入
 *
 * @Author: zyy
 * @Date: 2024/6/26 17:09
 * @Version:
 * @Description:
 */
@Slf4j
public class DITest {
    public static void main(String[] args) {

        getBeanAndInjectionDependency();
    }

    /**
     * 1. 在xml里没有配置bean的property 直接获取bean 打印出来的内容可以看到 对象的属性都为null
     * 2. 在xml里为bean配置对应的property value，打印可以看到对应的属性,但是zoo的monkey没有值，因为并没有为其赋值
     * 3. 在xml里为zoo配置monkey对象，使用ref表式关联到beanId为monkey的bean
     * 针对小册p5里h3的题目: 依赖查找(获取对象)和依赖注入(管理对象的依赖)的对比
     * 依赖查找: 主要是获取bean对象的方式
     * 依赖注入: 将对象的属性注入到bean里，spring可以自动管理、注入bean所需要的依赖属性
     */
    public static void getBeanAndInjectionDependency() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("basic_dl/quickstart_p2_case3.xml");
        Monkey monkey = context.getBean(Monkey.class);
        log.info("monkey:{}", monkey);

        Zoo zoo = context.getBean(Zoo.class);
        log.info("zoo:{}", zoo);
    }
}
