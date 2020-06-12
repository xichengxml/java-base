package com.xicheng.javabase.t01_exception.exception;

/**
 * description 无堆栈信息的异常
 *
 * @author xichengxml
 * @date 2020-06-12 16:37:05
 */
public class NoTraceStackException extends RuntimeException {

	public NoTraceStackException(String message) {
		super(message);
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		// ignore fillInStackTrace
		return this;
	}
}
