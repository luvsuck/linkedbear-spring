package com.luvsic.dao.impl;

import com.luvsic.dao.DemoDao;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zyy
 * @Date: 2024/6/19 16:01
 * @Version:
 * @Description:
 */
public class DemoOracleDaoImpl implements DemoDao {
    @Override
    public List<String> findAll() {
        return Arrays.asList("Ora", "c", "le");
    }
}
