package com.jiangle.bigevent.controller;

import com.jiangle.bigevent.pojo.Category;
import com.jiangle.bigevent.pojo.Result;
import com.jiangle.bigevent.pojo.User;
import com.jiangle.bigevent.service.CategoryService;
import com.jiangle.bigevent.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // 添加分类
    @PostMapping("/addCategory")
    public Result addCategory(@RequestBody @Validated Category category) {
        User loginUser = TokenUtils.getObject(User.class);
        category.setCreateUsername(loginUser.getUsername());
        return categoryService.addCategory(category);
    }

    // 查询用户的分类信息
    @GetMapping("/list")
    public Result<List<Category>> listCategories() {
        User loginUser = TokenUtils.getObject(User.class);
        return categoryService.listCategories(loginUser);
    }

    // 查询某个分类的详情
    @GetMapping("/details")
    public Result<Category> details(@RequestParam String categoryName) {
        User loginUser = TokenUtils.getObject(User.class);
        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setCreateUsername(loginUser.getUsername());
        return categoryService.categoryDetails(category);
    }

    // 修改某个分类的信息(分类名无法修改)
    @GetMapping("/updateCategory")
    public Result updateCategory(@RequestBody @Validated Category category) {
        User loginUser = TokenUtils.getObject(User.class);
        category.setCreateUsername(loginUser.getUsername());
        return categoryService.updateCategory(category);
    }

    // 删除某个分类
    @DeleteMapping("/deleteCategory")
    public Result deleteCategory(@RequestParam("categoryName") String categoryName) {
        User loginUser = TokenUtils.getObject(User.class);
        Category category = new Category();
        category.setCreateUsername(loginUser.getUsername());
        category.setCategoryName(categoryName);
        return categoryService.deleteCategory(category);
    }

}
