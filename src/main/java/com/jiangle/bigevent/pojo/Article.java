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
import org.hibernate.validator.constraints.URL;

@Data
// 会在编译阶段自动生成getter、setter、toString、equals等方法
public class Article {
    @NotNull(groups = {ValidationUpdateArticle.class})
    private long id;
    @NotEmpty
    @Pattern(regexp = "^\\S{1,32}$")
    private String title;
    @NotNull
    @Pattern(regexp = "^\\S{0,10000}$")
    private String content;
    @NotNull
    @URL
    private String coverImg;
    @NotNull
    @Pattern(regexp = "^(草稿|已发布)$")
    private String state;
    @NotNull
    @Pattern(regexp = "\\S{1,32}$")
    private String categoryName;
    private String createUsername;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updateTime;

    public interface ValidationUpdateArticle extends Default {
    }

}
