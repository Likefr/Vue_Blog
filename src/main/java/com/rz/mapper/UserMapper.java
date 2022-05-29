package com.rz.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rz.entity.UserVo;
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
public interface UserMapper extends BaseMapper<UserVo> {

    IPage<UserVo> queryUserList(IPage<UserVo> page);
}
