package com.luvsic.dao.impl;

import com.luvsic.dao.DemoDao;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zyy
 * @Date: 2024/6/19 15:40
 * @Version:
 * @Description:
 */
public class DemoDaoImpl implements DemoDao {
    @Override
    public List<String> findAll() {
        return Arrays.asList("d", "e", "m", "o");
    }
}
