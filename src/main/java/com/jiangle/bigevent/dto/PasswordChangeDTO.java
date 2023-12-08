package com.jiangle.bigevent.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.jiangle.bigevent.pojo.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PasswordChangeDTO {
    @JsonAlias("old_pwd")
    @NotNull
    @Pattern(regexp = "\\S{8,32}$")
    private String oldPwd;

    @JsonAlias("new_pwd")
    @NotNull
    @Pattern(regexp = "\\S{8,32}$")
    private String newPwd;

    @JsonAlias("re_pwd")
    @NotNull
    @Pattern(regexp = "\\S{8,32}$")
    private String rePwd;
}
