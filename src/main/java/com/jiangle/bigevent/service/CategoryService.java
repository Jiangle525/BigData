package com.jiangle.bigevent.service;

import com.jiangle.bigevent.pojo.Category;
import com.jiangle.bigevent.pojo.Result;
import com.jiangle.bigevent.pojo.User;

import java.util.List;

public interface CategoryService {

    // 新增文章分类
    Result addCategory(Category category);

    // 查询用户分类列表
    Result<List<Category>> listCategories(User user);

    // 获取分类详情
    Result<Category> categoryDetails(Category category);

    // 更新分类信息
    Result updateCategory(Category category);

    // 删除指定分类
    Result deleteCategory(Category category);
}
