package com.xicheng.javabase.t01_exception.common;

import lombok.Getter;
import lombok.ToString;

/**
 * description 接口错误，五位错误码
 *
 * @author xichengxml
 * @date 2020-06-12 16:47:25
 */
@Getter
@ToString
public enum ResponseCodeEnum implements ResponseCodeBase {

	SUCCESS("00000","成功"),

	FAILURE("99999","失败");

	private String code;
	private String cnName;

	private ResponseCodeEnum(String code, String cnName) {
		this.code = code;
		this.cnName = cnName;
	}


	@Override
	public void populateResponse(BaseResponse response) {
		response.setRespCode(this.code);
		response.setRespDesc(this.cnName);
	}
}
