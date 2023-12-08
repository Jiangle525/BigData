package com.jiangle.bigevent.service.impl;

import com.jiangle.bigevent.mapper.CategoryMapper;
import com.jiangle.bigevent.pojo.Category;
import com.jiangle.bigevent.pojo.Result;
import com.jiangle.bigevent.pojo.User;
import com.jiangle.bigevent.service.CategoryService;
import com.jiangle.bigevent.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Result addCategory(Category category) {
        Category categoryDao = categoryMapper.queryCategory(category);
        if (categoryDao != null) {
            return Result.error("分类【" + category.getCategoryName() + "】已存在");
        }
        categoryMapper.addCategory(category);
        return Result.success();
    }

    @Override
    public Result<List<Category>> listCategories(User user) {
        List<Category> categories = categoryMapper.queryCategories(user);
        return Result.success(categories);
    }

    @Override
    public Result<Category> categoryDetails(Category category) {
        Category categoryDao = categoryMapper.queryCategory(category);
        return Result.success(categoryDao);
    }

    @Override
    public Result updateCategory(Category category) {
        int i = categoryMapper.updateCategory(category);
        if (i < 1) {
            return Result.error("分类【" + category.getCategoryName() + "】不存在");
        }
        return Result.success();
    }

    @Override
    public Result deleteCategory(Category category) {
        int i = categoryMapper.deleteCategory(category);
        if (i < 1) {
            return Result.error("分类【" + category.getCategoryName() + "】不存在");
        }
        return Result.success();
    }

}
