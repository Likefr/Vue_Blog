package com.rz.mapper;

import com.rz.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface ArticleMapper extends BaseMapper<Article> {
    List<Article> queryAllArticle();
}
