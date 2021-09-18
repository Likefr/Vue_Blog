package com.rz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rz.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
    //查询所有用户   --分页 todo
    List<User> queryAllUser();
}
