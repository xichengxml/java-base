package com.xicheng.javabase.t05_exceptionmapping.biz;

import com.xicheng.javabase.t05_exceptionmapping.rpc.ExceptionMappingRpc;
import com.xicheng.javabase.t05_exceptionmapping.response.ApiSystemResponse;
import com.xicheng.javabase.t05_exceptionmapping.response.SubSystemResponse;
import com.xicheng.javabase.t05_exceptionmapping.util.ExceptionMappingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-07-19 07:57
 */
@Service
@Slf4j
public class ExceptionMappingBiz {

    @Autowired
    private ExceptionMappingRpc exceptionMappingRpc;

    public ApiSystemResponse get() {
        SubSystemResponse subSystemResponse = exceptionMappingRpc.get();
        ApiSystemResponse apiSystemResponse = ExceptionMappingUtil.responseTransform(subSystemResponse);
        apiSystemResponse.setApiData(subSystemResponse.getSubData());
        log.info("ExceptionMappingBiz get response: {}", apiSystemResponse);
        return apiSystemResponse;
    }
}
