package com.jiangle.bigevent.pojo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
// 会在编译阶段自动生成getter、setter、toString、equals等方法
public class Article {

    @JsonIgnore
    private long id;
    private String title;
    private String content;
    private String coverImg;
    private String state;
    private String categoryName;
    private String createUsername;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updateTime;


}
