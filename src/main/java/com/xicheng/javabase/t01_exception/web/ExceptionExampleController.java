package com.xicheng.javabase.t01_exception.web;

import com.xicheng.javabase.t01_exception.common.BaseResponse;
import com.xicheng.javabase.t01_exception.service.ExceptionExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-12 17:39:46
 */
@RestController
@RequestMapping("/exception")
public class ExceptionExampleController {

	@Autowired
	private ExceptionExampleService exceptionExampleService;

	@RequestMapping("/withException")
	public BaseResponse withException() {
		return exceptionExampleService.doSomethingWithBizException();
	}

	@RequestMapping("/success")
	public BaseResponse success() {
		return exceptionExampleService.doSomethingSuccess();
	}

	@RequestMapping("/fail")
	public BaseResponse fail() {
		return exceptionExampleService.doSomethingFail();
	}
}
