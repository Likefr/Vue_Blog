package com.rz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rz.entity.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Likefr Vue Blog
 * @since 2022-05-29
 */
public interface UserService extends IService<UserVo> {
    public IPage<UserVo> queryUserList(IPage<UserVo> page);
}
