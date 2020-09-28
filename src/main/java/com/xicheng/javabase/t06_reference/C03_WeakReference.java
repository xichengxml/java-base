package com.xicheng.javabase.t06_reference;

import com.xicheng.javabase.t06_reference.common.M;
import lombok.extern.slf4j.Slf4j;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * description 弱引用
 *
 * @author xichengxml
 * @date 2020-09-29 00:19
 */
@Slf4j
public class C03_WeakReference {

    public static void main(String[] args) throws Exception {
        WeakReference<M> weakReference = new WeakReference<M>(new M());
        log.info("C03_WeakReference main before collect: {}", weakReference.get());
        // 执行垃圾回收就会回收
        System.gc();
        TimeUnit.SECONDS.sleep(10);
        log.info("C03_WeakReference main after collect: {}", weakReference.get());
        System.in.read();
    }
}
