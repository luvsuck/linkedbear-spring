package com.luvsic;

import com.luvsic.bean.Company;
import com.luvsic.bean.Country;
import com.luvsic.bean.Skill;
import com.luvsic.bean.Worker;
import com.luvsic.config.QuickStartConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: ${USER}
 * @Date: $DATE ${TIME}
 * @Version:
 * @Description:
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(QuickStartConfiguration.class);
        Country country = context.getBean(Country.class);
        log.info("country:{}", country);
        Company company = context.getBean(Company.class);
        log.info("company:{}", company);
        Worker worker = context.getBean(Worker.class);
        log.info("person:{}", worker);

        // 可以看到bean名称中，也包含使用@Configuration标识的配置类,@Configuration也用了@Component注解
        String[] definitionNames = context.getBeanDefinitionNames();
        for (int i = 0; i < definitionNames.length; i++) {
            log.info("definitionName[{}]:{}", i, definitionNames[i]);
        }

        // 这里我们配置了用@Component注解声明了Skill这个类为bean，但是在beanDefinitionNames并未找到对应的beanName
        // 是因为我们方才通过Component配置的bean，并没有被ioc容器感知到，比如在Configuration中，我们的bean是直接写在
        // 配置中的，但是配置中并无法知道要去哪里获取@Component标注的bean，为了解决这个问题，我们需要用@ComponentScan
        // 来指明需要扫描的包路径

        //假如没有指定@ComponentScan表明要扫的组件包，也可以用AnnotationConfigApplicationContext构造器传入一个basePackages
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.luvsic.bean", "com.luvsic.config");
//        Skill skill = ctx.getBean(Skill.class);
//        log.info("skill:{}", skill);

        System.out.println("--------------------------------");
        ClassPathXmlApplicationContext xmlCtx = new ClassPathXmlApplicationContext("quickstart_p3_case1.xml");
        String[] beanIds = xmlCtx.getBeanDefinitionNames();
        for (int i = 0; i < beanIds.length; i++) {
            log.info("bean[{}]:{}", i, beanIds[i]);
        }
        Skill skill = xmlCtx.getBean(Skill.class);
        log.info("skill:{}-{}", skill, System.identityHashCode(skill));
        Skill skill2 = xmlCtx.getBean(Skill.class);
        log.info("skill:{}-{}", skill2, System.identityHashCode(skill2));
    }

}