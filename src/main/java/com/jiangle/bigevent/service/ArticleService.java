package com.jiangle.bigevent.service;

import com.jiangle.bigevent.dto.ArticleDetailsDTO;
import com.jiangle.bigevent.dto.ArticleUpdateDTO;
import com.jiangle.bigevent.dto.ListArticlesDTO;
import com.jiangle.bigevent.pojo.Article;
import com.jiangle.bigevent.pojo.PageBean;
import com.jiangle.bigevent.pojo.Result;

public interface ArticleService {
    // 新增文章
    Result addArticle(Article article);

    // 查询文章（条件分页）
    Result<PageBean<Article>> listArticles(ListArticlesDTO listArticlesDTO);

    // 查询文章详细信息
    Result<Article> articleDetails(ArticleDetailsDTO articleDetailsDTO);

    // 更新文章信息
    Result updateArticle(ArticleUpdateDTO articleUpdateDTO);

    Result deleteArticle(ArticleDetailsDTO articleDetailsDTO);
}
