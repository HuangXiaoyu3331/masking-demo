package com.masking.demo.common.error;

public interface BaseError {

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    Integer getErrorCode();

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getErrorMsg();

}
