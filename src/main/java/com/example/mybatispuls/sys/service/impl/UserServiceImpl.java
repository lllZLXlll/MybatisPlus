package com.example.mybatispuls.sys.service.impl;

import com.example.mybatispuls.sys.entity.User;
import com.example.mybatispuls.sys.mapper.UserMapper;
import com.example.mybatispuls.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author zlx
 * @since 2018-11-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
