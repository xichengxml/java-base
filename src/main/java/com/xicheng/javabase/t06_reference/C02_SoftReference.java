package com.xicheng.javabase.t06_reference;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * description 软引用--适合缓存使用
 * jvm参数: -Xmx20M -XX:+PrintGC
 * 执行失败，没想明白原因；使用log会造成内存溢出
 * @author xichengxml
 * @date 2020-09-28 23:51
 */
@Slf4j
public class C02_SoftReference {

    public static void main(String[] args) throws Exception {
        byte[] cacheData = new byte[1024 * 1024 * 10];
        SoftReference<byte[]> softReference = new SoftReference<>(cacheData);
        cacheData = null;
//        log.info("C02_SoftReference main before collect: {}", softReference.get());
        System.out.println(softReference.get());
        System.gc();
        TimeUnit.SECONDS.sleep(10);
        // log.info("C02_SoftReference main after collect: {}", softReference.get());
        System.out.println(softReference.get());

        // 再分配15m，内存不够用，会回收软引用的10m
        byte[] bytes = new byte[1024 * 1024 * 15];
        System.out.println(softReference.get());
        // log.info("C02_SoftReference main after allocate another 15m: {}", softReference.get());
    }
}
