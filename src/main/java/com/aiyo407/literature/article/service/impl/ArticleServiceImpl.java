package com.aiyo407.literature.article.service.impl;

import com.aiyo407.literature.article.entity.Article;
import com.aiyo407.literature.article.mapper.ArticleMapper;
import com.aiyo407.literature.article.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luzh
 * @since 2020-06-04
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
