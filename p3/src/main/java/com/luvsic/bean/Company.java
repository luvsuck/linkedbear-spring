package com.luvsic.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zyy
 * @Date: 2024/6/27 17:57
 * @Version:
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private String name;
    private Worker worker;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", worker=" + worker +
                ", worker=" + System.identityHashCode(worker) +
                '}';
    }
}
