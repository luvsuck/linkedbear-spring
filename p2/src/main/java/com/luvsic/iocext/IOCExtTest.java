package com.luvsic.iocext;

import com.luvsic.iocext.dao.SqlDao;
import lombok.extern.slf4j.Slf4j;
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
}
