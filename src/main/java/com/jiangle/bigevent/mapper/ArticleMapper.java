package com.jiangle.bigevent.mapper;

import com.jiangle.bigevent.dto.ArticleDetailsDTO;
import com.jiangle.bigevent.dto.ArticleUpdateDTO;
import com.jiangle.bigevent.dto.ListArticlesDTO;
import com.jiangle.bigevent.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Insert("insert into article (title, content, cover_img, state, category_name, create_username, create_time, update_time)" +
            " values(#{title}, #{content}, #{coverImg}, #{state}, #{categoryName}, #{createUsername}, now(), now())")
    void addArticle(Article article);

    List<Article> listArticles(ListArticlesDTO listArticlesDTO);

    @Select("select * from article where id=#{id} and create_username=#{createUsername}")
    Article queryArticle(ArticleDetailsDTO articleDetailsDTO);

    int updateArticle(ArticleUpdateDTO articleUpdateDTO);

    @Delete("delete from article where create_username=#{createUsername} and id=#{id}")
    int deleteArticle(ArticleDetailsDTO articleDetailsDTO);

}
