package com.xicheng.javabase.t05_exceptionmapping.rpc;

import com.xicheng.javabase.t05_exceptionmapping.common.SubSystemExceptionEnum;
import com.xicheng.javabase.t05_exceptionmapping.response.SubSystemResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-07-19 07:57
 */
@Service
@Slf4j
public class ExceptionMappingRpc {

    public SubSystemResponse get() {
        // 模拟返回
        SubSystemResponse subSystemResponse = new SubSystemResponse();
        subSystemResponse.setResponseCode(SubSystemExceptionEnum.SUB001.getCode());
        subSystemResponse.setResponseMsg(SubSystemExceptionEnum.SUB001.getMessage());
        log.info("ExceptionMappingRpc get response: {}", subSystemResponse);
        return subSystemResponse;
    }
}
