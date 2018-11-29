package com.example.mybatispuls.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatispuls.test.entity.Test;
import com.example.mybatispuls.test.mapper.TestMapper;
import com.example.mybatispuls.test.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zlx
 * @since 2018-11-29
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

    @Autowired
    TestMapper testMapper;

    /**
     * Mapper CRUD 接口：com.baomidou.mybatisplus.core.mapper.BaseMapper
     * 实现了此接口，会有mybatis puls默认提供的基本CRUD接口，这些接口不需要在写xml文件去实现
     * <p>
     * 更多接口详情：
     * http://mp.baomidou.com/guide/crud-interface.html#service-crud-%E6%8E%A5%E5%8F%A3
     */
    @Override
    public Object queryCountById(int i) {
        // 创建查询条件对象
        QueryWrapper queryWrapper = new QueryWrapper();
        return testMapper.selectCount(queryWrapper.select());
    }

    /**
     * 条件构造器示例 begin
     */
    @Override
    public Object queryTest1() {
        QueryWrapper queryWrapper = new QueryWrapper();
        /**
         *   select:            指定要查询的字段;
         *   allEq:
         *      condition:      表示该条件是否加入最后生成的sql中
         *      params:         key为数据库字段名,value为字段值
         *      null2IsNull:    false时则忽略value为null的，true则会调用is null函数
         *
         */
        Map<String, String> params = new HashMap<>();
        params.put("name", "2");
        return testMapper.selectList(queryWrapper.select("id", "name").allEq(true, params, false));
    }

    @Override
    public Object queryTest2() {
        QueryWrapper queryWrapper = new QueryWrapper();
        return testMapper.selectList((Wrapper) queryWrapper.select("id", "name").like("name", "b"));
    }
    /**
     * 条件构造器示例 end 更多条件构造器：http://mp.baomidou.com/guide/wrapper.html#abstractwrapper
     */

    @Override
    public Page queryTest3(int current, int size) {
        Page<Test> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        return testMapper.selectListPage(page, "2");
    }


}
