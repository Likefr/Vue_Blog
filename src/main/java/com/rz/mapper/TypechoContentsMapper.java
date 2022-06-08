package com.rz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rz.entity.TypechoContents;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Likefr Vue Blog
 * @since 2022-06-05
 */
@Mapper
@Repository
public interface TypechoContentsMapper extends BaseMapper<TypechoContents> {
    IPage<TypechoContents> queryContents(IPage<TypechoContents> page);
}
