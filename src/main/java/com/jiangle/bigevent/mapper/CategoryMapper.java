package com.jiangle.bigevent.mapper;

import com.jiangle.bigevent.pojo.Category;
import com.jiangle.bigevent.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    // 新增分类
    @Insert("insert into category " +
            "(category_name, category_alias, create_username, create_time, update_time) values " +
            "(#{categoryName}, #{categoryAlias}, #{createUsername}, now(),now())")
    void addCategory(Category category);

    // 根据用户名和分类名查询分类
    @Select("select * from category where category_name=#{categoryName} and create_username=#{createUsername}")
    Category queryCategory(Category category);

    // 查询某个用户的所有分类
    @Select("select * from category where create_username=#{username}")
    List<Category> queryCategories(User user);

    // 更新某个分类
    @Update("update category set category_alias=#{categoryAlias}, update_time=now() " +
            "where create_username=#{createUsername} and category_name=#{categoryName}")
    int updateCategory(Category category);

    // 删除某个分类
    @Delete("delete from category where create_username=#{createUsername} and category_name=#{categoryName}")
    int deleteCategory(Category category);
}


