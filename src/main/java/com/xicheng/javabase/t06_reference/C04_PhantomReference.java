package com.xicheng.javabase.t06_reference;

import com.alibaba.fastjson.JSON;
import com.xicheng.javabase.t06_reference.common.M;
import jdk.nashorn.internal.runtime.JSONFunctions;
import lombok.extern.slf4j.Slf4j;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

/**
 * description 虚引用--用于回收堆外内存
 *
 * @author xichengxml
 * @date 2020-09-29 00:23
 */
@Slf4j
public class C04_PhantomReference {

    public static void main(String[] args) throws Exception {
        ReferenceQueue<M> referenceQueue = new ReferenceQueue<>();
        PhantomReference<M> phantomReference = new PhantomReference<>(new M(), referenceQueue);
        log.info("C04_PhantomReference main before collect: {}, queue: {}", phantomReference.get(), JSON.toJSONString(referenceQueue));
        ArrayList<Object> list = new ArrayList<>();
        new Thread(() -> {
            while (true) {
                Reference<? extends M> poll = referenceQueue.poll();
                list.add(new byte[1024 * 1024]);
                if (poll != null) {
                    log.info("C04_PhantomReference main after collect: {}, queue: {}", phantomReference.get(), JSON.toJSONString(referenceQueue));
                }
            }
        }).start();
        System.in.read();
    }
}
