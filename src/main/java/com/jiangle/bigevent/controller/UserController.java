package com.jiangle.bigevent.controller;

import com.jiangle.bigevent.dto.PasswordChangeDTO;
import com.jiangle.bigevent.pojo.Result;
import com.jiangle.bigevent.pojo.User;
import com.jiangle.bigevent.service.UserService;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    // 注册，请求参数格式：x-www-form-urlencoded
    @PostMapping("/register")
    public Result register(@ModelAttribute @Validated(User.ValidationUserRegister.class) User user) {
        return userService.register(user);
    }

    // 登录，请求参数格式：x-www-form-urlencoded
    @PostMapping("/login")
    public Result login(@ModelAttribute @Validated(User.ValidationUserRegister.class) User user) {
        return userService.login(user);
    }

    // 获取用户详细信息
    @GetMapping("/userinfo")
    public Result<User> userInfo() {
        return userService.userInfo();
    }

    // 更新用户基本信息，请求参数格式：application/json
    @PutMapping("/update")
    public Result update(@RequestBody @Validated(User.ValidationUserUpdate.class) User user) {
        return userService.updateUser(user);
    }

    // 更换头像，请求参数格式：queryString
    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam("avatarUrl") @NotEmpty @URL String avatarUrl) {
        User user = new User();
        user.setUserPic(avatarUrl);
        return userService.updateAvatar(user);
    }

    // 更新密码
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody @Validated PasswordChangeDTO pwdDTO) {
        return userService.updatePwd(pwdDTO.getOldPwd(), pwdDTO.getNewPwd(), pwdDTO.getRePwd());
    }
}
