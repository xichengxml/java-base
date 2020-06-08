package com.xicheng.javabase.t03_exceptionhandler.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-08 16:30:15
 */
@RestController
@RequestMapping("/exception/handler")
public class ExceptionHandlerController {

	@RequestMapping("/noException")
	public String noException() {
		return "noException";
	}

	@RequestMapping("/withException")
	public String withException() {
		if (true) {
			throw new RuntimeException("错误");
		}
		return "withException";
	}
}
