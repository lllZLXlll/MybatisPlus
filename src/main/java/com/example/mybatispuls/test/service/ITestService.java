package com.example.mybatispuls.test.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatispuls.test.entity.Test;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zlx
 * @since 2018-11-29
 */
public interface ITestService extends IService<Test> {

    Object queryCountById(int i);

    Object queryTest1();

    Object queryTest2();

    Page queryTest3(int current, int size);
}
