package com.jiangle.bigevent.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    // 操作成功，带返回数据
    public static <T> Result<T> success(T data) {
        return new Result(0, "操作成功", data);
    }

    // 操作成功，无返回数据
    public static Result success() {
        return new Result(0, "操作成功", null);
    }

    // 操作失败
    public static Result error(String message) {
        return new Result(-1, message, null);
    }

}
