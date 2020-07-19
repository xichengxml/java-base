package com.xicheng.javabase.t05_exceptionmapping.common;

import lombok.Getter;
import lombok.ToString;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-07-19 08:16
 */
@Getter
@ToString
public enum ApiSystemExceptionEnum {

    API001("api001", "api 001错误"),
    API002("api002", "api 002错误"),
    UNKNOWN_EXCEPTION("unknown", "未知错误");

    private String code;

    private String message;


    ApiSystemExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
