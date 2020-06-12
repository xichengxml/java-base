package com.xicheng.javabase.t01_exception.service;

import com.xicheng.javabase.t01_exception.common.BaseResponse;

/**
 * description
 *
 * @author xichengxml
 * @date @date 2020-06-12 17:09:31
 */
public interface ExceptionExampleService {

	BaseResponse doSomethingWithBizException();

	BaseResponse doSomethingSuccess();

	BaseResponse doSomethingFail();
}
