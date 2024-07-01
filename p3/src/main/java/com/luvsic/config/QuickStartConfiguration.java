package com.luvsic.config;

import com.luvsic.bean.Company;
import com.luvsic.bean.Country;
import com.luvsic.bean.Worker;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 配置类
 *
 * @Author: zyy
 * @Date: 2024/6/27 17:39
 * @Version:
 * @Description: spring配置类 代替xml来声明bean以及属性注入
 */
@Component
//@Configuration
//指明要扫描的@Component注解标注的类的包路径
//@ComponentScan("com.luvsic.bean")

//假如不指定@ComponentScan的value或者basePackages，会默认扫描该类所在包以及子包下所有的@Component组件 ，这样就能把Tank 这个bean给注册进容器
//@ComponentScan

// basePackages或者说value可以指定多个basePackage
//@ComponentScan(value = {"com.luvsic.bean", "com.luvsic.config"})


public class QuickStartConfiguration {

    /**
     * @return s
     * Bean注解相当于xml配置里的
     * <bean id="worker001" class="com.**.Worker"">
     * <property name="name" value="张三"/>
     * <property name="name" value="张三"/>
     * </bean>
     */
    @Bean(name = "china")
    public Country country() {
        return new Country("中国", worker());
    }

    @Bean(name = "worker001")
    public Worker worker() {
        return new Worker("张三", new Random().nextInt(80));
    }

    @Bean("company001")
    public Company company() {
        return new Company("杜绝996", worker());
    }
}
