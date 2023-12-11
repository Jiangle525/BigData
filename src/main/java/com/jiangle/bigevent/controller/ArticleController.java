package com.jiangle.bigevent.controller;

import com.jiangle.bigevent.dto.ArticleDetailsDTO;
import com.jiangle.bigevent.dto.ArticleUpdateDTO;
import com.jiangle.bigevent.dto.ListArticlesDTO;
import com.jiangle.bigevent.pojo.Article;
import com.jiangle.bigevent.pojo.PageBean;
import com.jiangle.bigevent.pojo.Result;
import com.jiangle.bigevent.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/addArticle")
    public Result addArticle(@RequestBody @Validated Article article) {
        return articleService.addArticle(article);
    }

    @GetMapping("/listArticle")
    public Result<PageBean<Article>> listArticle(@ModelAttribute @Validated ListArticlesDTO listArticlesDTO) {
        return articleService.listArticles(listArticlesDTO);
    }

    @GetMapping("/details")
    public Result<Article> articleDetails(@ModelAttribute ArticleDetailsDTO articleDetailsDTO){
        return articleService.articleDetails(articleDetailsDTO);
    }

    @PostMapping("/updateArticle")
    public Result updateArticle(@RequestBody @Validated ArticleUpdateDTO articleUpdateDTO) {
        return articleService.updateArticle(articleUpdateDTO);
    }

    @DeleteMapping("/deleteArticle")
    public Result deleteArticle(@ModelAttribute ArticleDetailsDTO articleDetailsDTO){
        return articleService.deleteArticle(articleDetailsDTO);
    }

}
