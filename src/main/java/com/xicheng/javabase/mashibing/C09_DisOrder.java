package com.xicheng.javabase.mashibing;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * description 指令重排序的小例子
 *
 * @author xichengxml
 * @date 2020-10-10 21:01
 */
@Slf4j
public class C09_DisOrder {

    private static int a, b, x, y = 0;

    public static void main(String[] args) throws Exception {

        int i = 0;
        for (; ; ) {
            new Thread(() -> {
                a = 1;
                x = b;
            }, "t1").start();

            new Thread(() -> {
                b = 1;
                y = a;
            }, "t2").start();

            // 要保证线程1和线程2启动执行
            TimeUnit.MILLISECONDS.sleep(1);
            if (x == 0 && y == 0) {
                log.info("第{}次循环, x: {}. y: {}", i, x, y);
                break;
            }
            i++;
        }
    }
}
