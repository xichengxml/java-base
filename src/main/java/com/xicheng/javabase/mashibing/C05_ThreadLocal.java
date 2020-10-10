package com.xicheng.javabase.mashibing;

import com.xicheng.javabase.common.LogUtil;
import com.xicheng.javabase.mashibing.common.M;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * description 线程池慎用threadlocal，值可能会复用
 *
 * @author xichengxml
 * @date 2020-09-30 08:00
 */
@Slf4j
public class C05_ThreadLocal {

    private static final ThreadLocal<M> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            THREAD_LOCAL.set(new M());
        }, "thread01").start();
        TimeUnit.SECONDS.sleep(10);
        new Thread(() -> {
            M m = THREAD_LOCAL.get();
            LogUtil.info(log, "m: {}", m);
        }, "thread02").start();
    }
}
