package com.rz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rz.entity.UserVo;
import com.rz.mapper.UserMapper;
import com.rz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Likefr Vue Blog
 * @since 2022-05-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserVo> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public IPage<UserVo> queryUserList(IPage<UserVo> page) {
        return userMapper.queryUserList(page);
    }
}
