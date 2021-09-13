package com.rz.mapper;

import com.rz.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Likefr Vue Blog
 * @since 2021-09-13
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User getUserByUsername(String username);
}
