package com.jiangle.bigevent.mapper;

import com.jiangle.bigevent.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    // 查找用户
    @Select("select * from user where username=#{username}")
    public User queryUser(User user);

    // 新增用户
    @Insert("insert into user (username, password, create_time, update_time) " +
            "values(#{username}, #{password}, now(), now())")
    public void addUser(User user);

    // 查询密码
    @Select("select password from user where username=#{username}")
    public String queryPassword(User user);

    // 修改用户基本信息(头像除外)
    @Update("update user set nickname=#{nickname}, email=#{email}, update_time=now() where username=#{username}")
    void updateUser(User user);

    // 修改用户头像
    @Update("update user set user_pic=#{userPic}, update_time=now() where username=#{username}")
    void updateAvatar(User user);

    // 修改用户密码
    @Update("update user set password=#{password}, update_time=now() where username=#{username}")
    void updateUserPwd(User user);
}
