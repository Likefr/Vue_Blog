package com.rz.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rz.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Likefr Vue Blog
 * @since 2022-05-29
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    IPage<User> queryUserList(IPage<User> page);
}
