package com.xicheng.javabase.t05_exceptionmapping.api.impl;

import com.xicheng.javabase.t05_exceptionmapping.biz.ExceptionMappingBiz;
import com.xicheng.javabase.t05_exceptionmapping.api.ExceptionMappingApi;
import com.xicheng.javabase.t05_exceptionmapping.response.ApiSystemResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-07-19 07:55
 */
@Service("exceptionMappingApi")
@Slf4j
public class ExceptionMappingApiImpl implements ExceptionMappingApi {

    @Autowired
    private ExceptionMappingBiz exceptionMappingBiz;

    @Override
    public void api() {
        ApiSystemResponse apiSystemResponse = exceptionMappingBiz.get();
        log.info("ExceptionMappingApiImpl api response: {}", apiSystemResponse);
    }
}
