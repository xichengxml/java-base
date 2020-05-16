package com.xicheng.javabase.t02_idempotence.common;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-05-16 22:41
 */
public interface TokenConstant {

    String TOKEN_PREFIX = "REDIS_TOKEN_%s";

    String TOKEN_NAME = "IDEMPOTENT_TOKEN";

}
