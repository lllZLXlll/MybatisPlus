package com.example.mybatispuls.test.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatispuls.test.entity.Test;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zlx
 * @since 2018-11-29
 */
public interface TestMapper extends BaseMapper<Test> {

    /**
     * TODO 此处要注意船参顺序和使用注解
     * @param page  分页对象，必须放在第一个参数
     * @param name  条件查询字段，必须要有@Param注释，否则找不到
     * @return
     */
    Page selectListPage(Page<Test> page, @Param("name") String name);
}
