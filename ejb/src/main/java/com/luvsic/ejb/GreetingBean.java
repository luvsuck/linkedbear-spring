package com.luvsic.ejb;

import jakarta.ejb.Stateless;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @Author: zyy
 * @Date: 2024/6/20 12:14
 * @Version:
 * @Description:
 */
@Stateless
public class GreetingBean {
    public void greet() {
        System.out.println("greet nice !");
        try {
            InitialContext context = new InitialContext();
            HelloBean bean = (HelloBean) context.lookup("java:global/ejb/HelloBean");
            String msg = bean.say("E J B");
            System.out.println(msg);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
