package com.luvsic.service.impl;

import com.luvsic.BeanFactory;
import com.luvsic.dao.DemoDao;
import com.luvsic.service.DemoService;

import java.util.List;

/**
 * @Author: zyy
 * @Date: 2024/6/19 15:43
 * @Version:
 * @Description:
 */
public class DemoServiceImpl implements DemoService {
    //    private DemoDao demoDao = BeanFactory.getDemoDao();
//    private DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");
    private DemoDao demoDao = (DemoDao) BeanFactory.getSingleBean("demoDao");

    @Override
    public List<String> findAll() {
        System.out.println(demoDao);
        return demoDao.findAll();
    }

    /**
     * 1.问题: 连续生成10个dao可以看到他们的内存地址完全不一样
     */
    public DemoServiceImpl() {
        for (int i = 0; i < 10; i++) {
            Object dao = BeanFactory.getSingleBean("demoDao");
            System.out.println(i + " :" + dao);
        }
    }

}
