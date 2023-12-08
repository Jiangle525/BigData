package com.jiangle.bigevent.pojo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.Data;

@Data
// 会在编译阶段自动生成getter、setter、toString、equals等方法
public class Category {

    @JsonIgnore
    private long id;

    @NotEmpty
    @Pattern(regexp = "\\S{1,32}$")
    private String categoryName;

    @Nullable
    @Pattern(regexp = "\\S{1,32}$")
    private String categoryAlias;

    @JsonIgnore
    private String createUsername;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updateTime;

}
