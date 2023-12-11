package com.jiangle.bigevent.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jiangle.bigevent.dto.ArticleDetailsDTO;
import com.jiangle.bigevent.dto.ArticleUpdateDTO;
import com.jiangle.bigevent.dto.ListArticlesDTO;
import com.jiangle.bigevent.mapper.ArticleMapper;
import com.jiangle.bigevent.pojo.Article;
import com.jiangle.bigevent.pojo.PageBean;
import com.jiangle.bigevent.pojo.Result;
import com.jiangle.bigevent.pojo.User;
import com.jiangle.bigevent.service.ArticleService;
import com.jiangle.bigevent.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Result addArticle(Article article) {
        User loginUser = TokenUtils.getObject(User.class);
        article.setCreateUsername(loginUser.getUsername());
        articleMapper.addArticle(article);
        return Result.success();
    }

    @Override
    public Result<PageBean<Article>> listArticles(ListArticlesDTO listArticlesDTO) {
        User loginUser = TokenUtils.getObject(User.class);
        listArticlesDTO.setCreateUsername(loginUser.getUsername());
        // 创建 PageBean
        PageBean<Article> pageBean = new PageBean<>();
        // 开启分页查询
        PageHelper.startPage(listArticlesDTO.getPageNum(), listArticlesDTO.getPageSize());

        // 调用 mapper 完成查询，并将查询的集合强转为Page类型的对象
        Page<Article> articlesPage = (Page<Article>) articleMapper.listArticles(listArticlesDTO);

        // 将数据填充到 PageBean 中
        pageBean.setItems(articlesPage.getResult());
        pageBean.setTotal(articlesPage.getTotal());

        return Result.success(pageBean);
    }

    @Override
    public Result<Article> articleDetails(ArticleDetailsDTO articleDetailsDTO) {
        User loginUser = TokenUtils.getObject(User.class);
        articleDetailsDTO.setCreateUsername(loginUser.getUsername());
        Article article = articleMapper.queryArticle(articleDetailsDTO);
        return Result.success(article);
    }

    @Override
    public Result updateArticle(ArticleUpdateDTO articleUpdateDTO) {
        User loginUser = TokenUtils.getObject(User.class);
        articleUpdateDTO.setCreateUsername(loginUser.getUsername());
        int i = articleMapper.updateArticle(articleUpdateDTO);
        if (i < 1) {
            return Result.error("用户【" + loginUser.getUsername() + "】不存在id为【" + articleUpdateDTO.getId() + "】的文章");
        }
        return Result.success();
    }

    @Override
    public Result deleteArticle(ArticleDetailsDTO articleDetailsDTO) {
        User loginUser = TokenUtils.getObject(User.class);
        articleDetailsDTO.setCreateUsername(loginUser.getUsername());
        int i = articleMapper.deleteArticle(articleDetailsDTO);
        if (i < 1) {
            return Result.error("用户【" + loginUser.getUsername() + "】不存在id为【" + articleDetailsDTO.getId() + "】的文章");
        }
        return Result.success();
    }
}
