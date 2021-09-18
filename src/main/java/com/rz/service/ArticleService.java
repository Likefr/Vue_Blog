package com.rz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rz.entity.Article;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Likefr Vue Blog
 * @since 2021-09-13
 */
public interface ArticleService extends IService<Article> {
    List<Article> queryAllArticle();
}
