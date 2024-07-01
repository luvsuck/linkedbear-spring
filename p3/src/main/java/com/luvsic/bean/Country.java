package com.luvsic.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zyy
 * @Date: 2024/6/28 12:02
 * @Version:
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    private String name;
    private Worker worker;

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", worker=" + worker +
                ", worker=" + System.identityHashCode(worker) +
                '}';
    }
}
