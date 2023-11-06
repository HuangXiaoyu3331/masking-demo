package com.masking.demo.common.error;

public enum SystemError implements BaseError {
    /**
     * 系统错误
     */
    SYSTEM_ERROR(100_000, "系统错误,请联系管理员"),
    /**
     * 参数解析失败
     */
    PARSE_PARAMS_FAIL(100_001, "参数解析失败"),
    /**
     * 请求方法不支持
     */
    METHOD_NOT_SUPPORTED(100_002, "请求方法不支持"),
    /**
     * 不支持当前媒体类型
     */
    CURRENT_MEDIA_TYPE_NOT_SUPPORTED(100_003, "不支持当前媒体类型"),
    /**
     * 用户未登录/登录过期
     */
    UNAUTHORIZED(100_004, "用户未登录/登录过期"),

    ;

    SystemError(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    private final Integer errorCode;
    private final String errorMsg;

    @Override
    public Integer getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

}
