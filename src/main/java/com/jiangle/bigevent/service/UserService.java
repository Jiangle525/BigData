package com.jiangle.bigevent.service;

import com.jiangle.bigevent.pojo.Result;
import com.jiangle.bigevent.pojo.User;

public interface UserService {
    // 用户注册
    Result register(User user);

    // 用户登录
    Result login(User user);

    // 获取用户基本信息
    Result<User> userInfo();

    // 更新用户基本信息
    Result updateUser(User user);

    // 更新用户头像
    Result updateAvatar(User user);

    // 修改用户密码
    Result updatePwd(String oldPwd, String newPwd, String rePwd);
}
