package com.example.mybatispuls.sys.service.impl;

import com.example.mybatispuls.sys.entity.Dept;
import com.example.mybatispuls.sys.mapper.DeptMapper;
import com.example.mybatispuls.sys.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author zlx
 * @since 2018-11-29
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
