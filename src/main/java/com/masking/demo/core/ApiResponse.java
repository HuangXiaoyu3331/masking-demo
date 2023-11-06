package com.masking.demo.core;

import com.masking.demo.common.error.BaseError;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Objects;

@Slf4j
@ToString
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 6140983009066933934L;

    /**
     * 响应码
     */
    @Getter
    private int code;
    /**
     * 提示信息
     */
    @Getter
    private String msg = "";
    /**
     * 返回的数据
     */
    @Getter
    private T data;

    private ApiResponse() {
    }

    private ApiResponse(int code) {
        this.code = code;
        this.msg = "SUCCESS";
    }

    private ApiResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ApiResponse(int code, T data) {
        this.code = code;
        this.data = data;
        this.msg = "SUCCESS";
    }

    private ApiResponse(BaseError error) {
        this.code = error.getErrorCode();
        this.msg = error.getErrorMsg();
    }

    /**
     * 请求成功
     */
    public static <T> ApiResponse<T> createBySuccess() {
        return new ApiResponse<>(ResponseCode.SUCCESS.getCode());
    }

    /**
     * 请求成功，带数据
     *
     * @param data 请求成功数据
     */
    public static <T> ApiResponse<T> createBySuccess(T data) {
        return new ApiResponse<>(ResponseCode.SUCCESS.getCode(), data);
    }

    /**
     * 请求失败，带失败状态码跟描述
     * 目前只在异常拦截使用，其他地方建议使用 createByError(BaseError error) 方法代替
     *
     * @param errorCode 错误吗
     * @param errorMsg 错误信息
     */
    public static <T> ApiResponse<T> createByErrorCodeMessage(int errorCode, String errorMsg) {
        return new ApiResponse<>(errorCode, errorMsg);
    }

    /**
     * 请求失败
     *
     * @param error 错误枚举
     */
    public static <T> ApiResponse<T> createByError(BaseError error) {
        return new ApiResponse<>(error);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApiResponse<?> response = (ApiResponse<?>) o;
        return code == response.code &&
                Objects.equals(msg, response.msg) &&
                Objects.equals(data, response.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, msg, data);
    }

}

