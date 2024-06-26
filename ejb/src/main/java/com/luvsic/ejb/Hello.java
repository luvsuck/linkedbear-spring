package com.luvsic.ejb;

import jakarta.ejb.Remote;

/**
 * @Author: zyy
 * @Date: 2024/6/20 12:13
 * @Version:
 * @Description:
 */
@Remote
public interface Hello {
    String say(String name);
}
