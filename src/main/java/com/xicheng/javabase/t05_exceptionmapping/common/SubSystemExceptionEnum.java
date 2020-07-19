package com.xicheng.javabase.t05_exceptionmapping.common;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-07-19 08:16
 */
@Getter
@ToString
public enum SubSystemExceptionEnum {

    SUB001("api001", "sub 001错误"),
    SUB002("api002", "sub 002错误");

    private String code;

    private String message;


    SubSystemExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private static final Map<String, SubSystemExceptionEnum> container = new HashMap<>();

    public static SubSystemExceptionEnum getEnum(String code) {
        return getEnum(code, false);
    }

    public static SubSystemExceptionEnum getEnum(String code, boolean allowNull) {
        SubSystemExceptionEnum e = container.get(code);
        if (e == null && !allowNull) {
            throw new IllegalArgumentException("no enums code '" + code + "'. ");
        } else {
            return e;
        }
    }

    static {
        SubSystemExceptionEnum[] enumArr = values();
        for (SubSystemExceptionEnum subSystemExceptionEnum : enumArr) {
            container.put(subSystemExceptionEnum.code, subSystemExceptionEnum);
        }
    }
}
