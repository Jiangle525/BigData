package com.jiangle.bigevent.service.impl;

import com.jiangle.bigevent.mapper.UserMapper;
import com.jiangle.bigevent.pojo.Result;
import com.jiangle.bigevent.pojo.User;
import com.jiangle.bigevent.service.UserService;
import com.jiangle.bigevent.utils.EncryptionUtils;
import com.jiangle.bigevent.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result register(User registerUser) {
        // 检查用户是否已经存在
        User userDao = userMapper.queryUser(registerUser);
        if (userDao != null) {
            return Result.error("用户名已被占用");
        }
        // 注册，将密码加密存储
        String encryptPassword = EncryptionUtils.encryptPassword(registerUser.getPassword());
        registerUser.setPassword(encryptPassword);
        userMapper.addUser(registerUser);
        return Result.success();
    }

    @Override
    public Result login(User loginUser) {
        // 检查用户是否已经存在
        User userDao = userMapper.queryUser(loginUser);
        if (userDao == null) {
            return Result.error("用户名或密码错误");
        }
        // 验证登录密码
        boolean loginStatus = EncryptionUtils.verifyPassword(loginUser.getPassword(), userDao.getPassword());
        if (!loginStatus) {
            return Result.error("用户名或密码错误");
        }
        // 登录成功，生成token
        loginUser.setPassword("******");
        String token = TokenUtils.genToken(loginUser);
        return Result.success(token);
    }

    @Override
    public Result<User> userInfo() {
        User loginUser = TokenUtils.getObject(User.class);
        User userDao = userMapper.queryUser(loginUser);
        return Result.success(userDao);
    }

    @Override
    public Result updateUser(User user) {
        User loginUser = TokenUtils.getObject(User.class);
        if (!User.compareUserByName(loginUser, user)) {
            return Result.error("登录用户与修改密码用户不一致");
        }
        userMapper.updateUser(user);
        return Result.success();
    }

    @Override
    public Result updateAvatar(User user) {
        User loginUser = TokenUtils.getObject(User.class);
        loginUser.setUserPic(user.getUserPic());
        userMapper.updateAvatar(loginUser);
        return Result.success();
    }

    @Override
    public Result updatePwd(String oldPwd, String newPwd, String rePwd) {
        if (!newPwd.equals(rePwd)) {
            return Result.error("两次填写的新密码不一致");
        }
        if (newPwd.equals(oldPwd)) {
            return Result.error("新旧密码不能一致");
        }
        User loginUser = TokenUtils.getObject(User.class);
        // 验证密码
        String encryptOldPwd = userMapper.queryPassword(loginUser);
        boolean verifyPassword = EncryptionUtils.verifyPassword(oldPwd, encryptOldPwd);
        if (!verifyPassword) {
            return Result.error("原密码错误");
        }
        // 更新密码
        loginUser.setPassword(EncryptionUtils.encryptPassword(newPwd));
        userMapper.updateUserPwd(loginUser);
        return Result.success();
    }
}
