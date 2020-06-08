package com.xicheng.javabase.t03_exceptionhandler.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-08 16:32:15
 */
@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class})
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ModelAndView processUnauthenticatedException(NativeWebRequest request, RuntimeException e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notExist");
		return mv;
	}
}
