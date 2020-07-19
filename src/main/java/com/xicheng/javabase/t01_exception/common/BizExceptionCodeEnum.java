package com.xicheng.javabase.t01_exception.common;

import lombok.Getter;
import lombok.ToString;

/**
 * description 业务错误, 6位错误码
 *
 * @author xichengxml
 * @date 2020-06-12 16:45:09
 */
@Getter
@ToString
public enum BizExceptionCodeEnum implements ResponseCodeBase {

	NOT_EXIST_IN_DATABASE("500000", "数据库中不存在"),

	NOT_EXIST_IN_REDIS("500001", "缓存不存在"),

	DUPLICATE_REQUEST("500002", "重复请求");

	private String code;

	private String cnName;

	BizExceptionCodeEnum(String code, String cnName) {
		this.code = code;
		this.cnName = cnName;
	}

	@Override
	public void populateResponse(BaseResponse response) {
		response.setRespCode(this.code);
		response.setRespDesc(this.cnName);
	}
}
