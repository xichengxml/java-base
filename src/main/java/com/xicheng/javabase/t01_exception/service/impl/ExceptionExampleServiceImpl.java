package com.xicheng.javabase.t01_exception.service.impl;

import com.xicheng.javabase.t01_exception.common.BaseResponse;
import com.xicheng.javabase.t01_exception.common.BizExceptionCodeEnum;
import com.xicheng.javabase.t01_exception.common.ResponseCodeEnum;
import com.xicheng.javabase.t01_exception.exception.NotExistInDatabaseException;
import com.xicheng.javabase.t01_exception.service.ExceptionExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-12 17:09:04
 */
@Service
@Slf4j
public class ExceptionExampleServiceImpl implements ExceptionExampleService {

	@Override
	public BaseResponse doSomethingWithBizException() {
		BaseResponse baseResponse = new BaseResponse();
		try {
			databaseException();
			ResponseCodeEnum.SUCCESS.populateResponse(baseResponse);
		} catch (NotExistInDatabaseException e) {
			log.error("ExampleServiceImpl doSomethingWithBizException biz error: ", e);
			BizExceptionCodeEnum.NOT_EXIST_IN_DATABASE.populateResponse(baseResponse);
		} catch (Exception e) {
			log.error("ExampleServiceImpl doSomethingWithBizException error: ", e);
			ResponseCodeEnum.FAILURE.populateResponse(baseResponse);
		}
		log.info("ExampleServiceImpl doSomethingWithBizException response: {}", baseResponse);
		return baseResponse;
	}

	@Override
	public BaseResponse doSomethingSuccess() {
		BaseResponse baseResponse = new BaseResponse();
		ResponseCodeEnum.SUCCESS.populateResponse(baseResponse);
		return baseResponse;
	}

	@Override
	public BaseResponse doSomethingFail() {
		BaseResponse baseResponse = new BaseResponse();
		ResponseCodeEnum.FAILURE.populateResponse(baseResponse);
		return baseResponse;
	}

	private void databaseException() {
		throw new NotExistInDatabaseException("数据库中不存在相应数据");
	}
}
