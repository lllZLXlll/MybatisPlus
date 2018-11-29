package com.example.mybatispuls.test.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatispuls.test.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zlx
 * @since 2018-11-29
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    ITestService iTestService;

    /**
     * Service CRUD 接口：com.baomidou.mybatisplus.extension.service.IService
     * 实现了此接口，会有mybatis puls默认提供的基本CRUD接口，这些接口不需要在写mapper接口类和xml文件去实现
     *
     * 更多接口详情：
     * http://mp.baomidou.com/guide/crud-interface.html#service-crud-%E6%8E%A5%E5%8F%A3
     */
    @RequestMapping("/test")
    public Object test() {
        return iTestService.getById(1);
    }

    // 根据id查询
    @RequestMapping("/test0")
    public Object test0() {
        return iTestService.queryCountById(1);
    }

    // 根据id查询
    @RequestMapping("/test1")
    public Object test1() {
        return iTestService.queryTest1();
    }

    // 根据值模糊查询
    @RequestMapping("/test2")
    public Object test2() {
        return iTestService.queryTest2();
    }

    // 使用插件分页查询
    @RequestMapping("/test3/{current}/{size}")
    public Page test3(@PathVariable int current, @PathVariable int size) {
        return iTestService.queryTest3(current, size);
    }

}
