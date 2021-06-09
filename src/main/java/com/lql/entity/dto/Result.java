package com.lql.entity.dto;

import lombok.Data;

/**
 * @author lql
 * @date 2021/6/3 16:34
 * Description：
 */
@Data
public class Result<T> {

    //本次请求的状态码  200 表示成功
    private int code;

    //本次请求结果的详情
    private String msg;

    // 本次请求返回的结果集
    private T data;

}
