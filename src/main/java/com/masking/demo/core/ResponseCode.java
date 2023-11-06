package com.masking.demo.core;

import lombok.Getter;

public enum ResponseCode {
    //请求成功状态码
    SUCCESS(0, "SUCCESS")
    ;

    /**
     * 状态码
     */
    @Getter
    private final int code;
    /**
     * 描述
     */
    @Getter
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
