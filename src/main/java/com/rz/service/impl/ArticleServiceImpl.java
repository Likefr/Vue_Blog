package com.rz.service.impl;

import com.rz.entity.Article;
import com.rz.mapper.ArticleMapper;
import com.rz.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Likefr Vue Blog
 * @since 2021-09-13
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
