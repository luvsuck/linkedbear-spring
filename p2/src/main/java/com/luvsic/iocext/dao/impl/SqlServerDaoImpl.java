package com.luvsic.iocext.dao.impl;

import com.luvsic.iocext.dao.SqlDao;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zyy
 * @Date: 2024/6/26 17:36
 * @Version:
 * @Description:
 */
public class SqlServerDaoImpl implements SqlDao {
    @Override
    public List<String> findAll() {
        return Arrays.asList("Sql", "Server");
    }
}
