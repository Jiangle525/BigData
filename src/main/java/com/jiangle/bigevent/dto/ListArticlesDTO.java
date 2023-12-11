package com.jiangle.bigevent.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ListArticlesDTO {
    @NotNull
    private Integer pageNum;
    @NotNull
    private Integer pageSize;
    @Nullable
    @Pattern(regexp = "\\S{1,32}$")
    private String categoryName;
    @Nullable
    @Pattern(regexp = "^(草稿|已发布)$")
    private String state;
    @JsonIgnore
    private String createUsername;
}
