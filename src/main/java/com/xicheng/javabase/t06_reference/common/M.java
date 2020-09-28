package com.xicheng.javabase.t06_reference.common;

import lombok.extern.slf4j.Slf4j;

/**
 * description 用作实例基类
 *
 * @author xichengxml
 * @date 2020-09-28 23:46
 */
@Slf4j
public class M {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        log.info("object m is collected by jvm: {}", this);
    }
}
