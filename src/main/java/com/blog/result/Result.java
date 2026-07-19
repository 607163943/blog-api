package com.blog.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 数据
     */
    private T data;
    /**
     * 提示信息
     */
    private String msg;

    public static <T> Result<T> of(Integer code,T data,String msg) {
        return new Result<>(code, data, msg);
    }

    public static <T> Result<T> success(T data) {
        return Result.of(200, data, "success");
    }

    public static <T> Result<T> success() {
        return Result.of(200, null, "success");
    }
}
