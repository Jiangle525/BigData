package com.jiangle.bigevent.pojo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.core.annotation.AliasFor;

@Data
// 会在编译阶段自动生成getter、setter、toString、equals等方法
public class User {

    @JsonIgnore
    private long id;

    @NotEmpty(groups = {ValidationUsername.class})
    @Pattern(regexp = "\\S{4,20}$", groups = {ValidationUsername.class})
    private String username;

    @JsonIgnore
    @NotEmpty(groups = {ValidationPassword.class})
    @Pattern(regexp = "\\S{8,32}$", groups = {ValidationPassword.class})
    private String password;

    @Nullable
    @Pattern(regexp = "^\\S{0,20}$", groups = {ValidationNickName.class})
    private String nickname;

    @Nullable
    @Email(groups = {ValidationEmail.class})
    private String email;

    @JsonAlias("avatarUrl")
    @NotEmpty(groups = {ValidationAvatarURL.class})
    @URL(groups = {ValidationAvatarURL.class})
    private String userPic;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updateTime;

    // 某个校验如果不指定分组，则默认属于Default分组
    // 将分组继承自Default后，就满足Default的分组校验

    public interface ValidationUserRegister extends ValidationUsername, ValidationPassword {
    }

    public interface ValidationUserUpdate extends ValidationUsername, ValidationEmail {
    }

    public interface ValidationAvatarURL extends Default {
    }

    private interface ValidationPassword extends Default {
    }

    private interface ValidationUsername extends Default {
    }

    private interface ValidationNickName extends Default {
    }

    private interface ValidationEmail extends Default {
    }


    public static boolean compareUserByName(User user1, User user2) {
        return user1 != null && user2 != null && user1.username.toLowerCase().equals(user2.username.toLowerCase());
    }
}
