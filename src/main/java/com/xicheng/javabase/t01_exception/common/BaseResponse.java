package com.xicheng.javabase.t01_exception.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-12 17:11:26
 */
@Data
public class BaseResponse implements Serializable {

	private static final Date responseTime = new Date();

	private String respCode;

	private String respDesc;
}
