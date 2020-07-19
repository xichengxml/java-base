package com.xicheng.javabase.t05_exceptionmapping.util;

import com.xicheng.javabase.t05_exceptionmapping.common.ApiSystemExceptionEnum;
import com.xicheng.javabase.t05_exceptionmapping.common.SubSystemExceptionEnum;
import com.xicheng.javabase.t05_exceptionmapping.response.ApiSystemResponse;
import com.xicheng.javabase.t05_exceptionmapping.response.SubSystemResponse;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-07-19 08:28
 */
public class ExceptionMappingUtil {

    public static ApiSystemResponse responseTransform(SubSystemResponse subSystemResponse) {
        String responseCode = subSystemResponse.getResponseCode();
        SubSystemExceptionEnum subSystemExceptionEnum = SubSystemExceptionEnum.getEnum(responseCode);
        ApiSystemResponse apiSystemResponse = new ApiSystemResponse();
        switch (subSystemExceptionEnum) {
            case SUB001:
                apiSystemResponse.setResponseCode(ApiSystemExceptionEnum.API001.getCode());
                apiSystemResponse.setResponseMsg(ApiSystemExceptionEnum.API001.getMessage());
                break;
            case SUB002:
                apiSystemResponse.setResponseCode(ApiSystemExceptionEnum.API002.getCode());
                apiSystemResponse.setResponseMsg(ApiSystemExceptionEnum.API002.getMessage());
                break;
            default:
                apiSystemResponse.setResponseCode(ApiSystemExceptionEnum.UNKNOWN_EXCEPTION.getCode());
                apiSystemResponse.setResponseMsg(ApiSystemExceptionEnum.UNKNOWN_EXCEPTION.getMessage());
        }
        return apiSystemResponse;
    }
}
