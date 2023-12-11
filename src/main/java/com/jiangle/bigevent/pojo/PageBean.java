package com.jiangle.bigevent.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    private long total;     // 总条数
    private List<T> items;  // 当前页的数据集合
}
