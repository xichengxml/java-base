package com.xicheng.javabase.mashibing;

import lombok.extern.slf4j.Slf4j;

/**
 * description DCL单例一定要使用volatile修饰，否则可能会导致某个线程使用了半初始化的对象
 *
 * @author xichengxml
 * @date 2020-10-10 21:22
 */
@Slf4j
public class C10_Volatile {

    private static volatile C10_Volatile INSTANCE;

    private C10_Volatile() {

    }

    public static C10_Volatile getInstance() {
        if (INSTANCE == null) {
            synchronized (C10_Volatile.class) {
                if (INSTANCE == null) {
                    INSTANCE = new C10_Volatile();
                }
            }
        }
        return INSTANCE;
    }
}
