package com.xicheng.javabase.t05_exceptionmapping.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-07-19 08:33
 */
@Getter
@Setter
@ToString(callSuper = true)
public class SubSystemResponse  extends BaseResponse {

    private String subData;
}
