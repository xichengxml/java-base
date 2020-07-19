package com.xicheng.javabase.t05_exceptionmapping.response;

import lombok.Data;

import java.io.Serializable;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-07-19 08:37
 */
@Data
public class BaseResponse implements Serializable {

    private String ResponseCode;

    private String ResponseMsg;
}
