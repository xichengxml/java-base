package com.xicheng.javabase.mashibing;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-10-10 20:48
 */
@Slf4j
public class C08_Volatile {

    private static boolean flag1 = true;

    private static volatile boolean flag2 = true;

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            log.info("t1 start");
            while (flag1);
            log.info("t1 end");
        }, "t1").start();

        // 一定要睡眠一段时间，否则可能出现的情况是t1线程还未开启，主线程就将flag改为false，导致结论不正确
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            log.info("t2 start");
            while (flag2);
            log.info("t2 end");
        }, "t2").start();
        TimeUnit.SECONDS.sleep(1);
        flag1 = false;
        flag2 = false;
        countDownLatch.await();
    }
}
