package com.luvsic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author: zyy
 * @Date: 2024/6/27 19:12
 * @Version:
 * @Description:
 */
@Configuration
@ComponentScan("com.luvsic.ext")
@ImportResource("classpath:quickstart_p3_case1.xml")
public class AnnotationConfiguration {

}
