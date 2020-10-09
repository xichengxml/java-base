package com.xicheng.javabase.common;

import org.slf4j.Logger;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-09-30 08:05
 */
public class LogUtil {

    public static void info(Logger log, String logFormat, Object... messages) {
        StringBuilder stringBuilder = new StringBuilder();
        String className = log.getName().substring(log.getName().lastIndexOf(".") + 1);
        stringBuilder.append(className).append(" main ").append(logFormat);
        log.info(stringBuilder.toString(), messages);
    }
}
