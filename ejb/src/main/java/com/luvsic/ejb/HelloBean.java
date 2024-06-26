package com.luvsic.ejb;

import jakarta.ejb.Stateless;

/**
 * @Author: zyy
 * @Date: 2024/6/20 12:14
 * @Version:
 * @Description:
 */
@Stateless
public class HelloBean implements Hello {
    @Override
    public String say(String name) {
        return "He say : Hello," + name;
    }
}
