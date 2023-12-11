package com.jiangle.bigevent.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;


@Data
public class ArticleUpdateDTO {
    @NotNull
    private long id;

    @Nullable
    private String title;

    @Nullable
    @Pattern(regexp = "^\\S{0,10000}$")
    private String content;

    @Nullable
    @URL
    private String coverImg;

    @Nullable
    @Pattern(regexp = "^(草稿|已发布)$")
    private String state;

    @Nullable
    @Pattern(regexp = "\\S{1,32}$")
    private String categoryName;

    @JsonIgnore
    private String createUsername;

}
