package com.example.mybatispuls.code.service.impl;

import com.example.mybatispuls.code.entity.Dbinfo;
import com.example.mybatispuls.code.mapper.DbinfoMapper;
import com.example.mybatispuls.code.service.IDbinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据库链接信息 服务实现类
 * </p>
 *
 * @author zlx
 * @since 2018-11-29
 */
@Service
public class DbinfoServiceImpl extends ServiceImpl<DbinfoMapper, Dbinfo> implements IDbinfoService {

}
