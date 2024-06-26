package com.luvsic.ioc.dao.impl;

import com.luvsic.ioc.dao.SqlDao;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zyy
 * @Date: 2024/6/26 16:12
 * @Version:
 * @Description:
 */
public class MysqlDaoImpl implements SqlDao {
    @Override
    public List<String> findAll() {
        return Arrays.asList("My", "Sql");

    }
}
