package com.xicheng.javabase.t01_exception.exception;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-12 17:32:44
 */
public class NotExistInDatabaseException extends NoTraceStackException {

	public NotExistInDatabaseException(String message) {
		super(message);
	}
}
