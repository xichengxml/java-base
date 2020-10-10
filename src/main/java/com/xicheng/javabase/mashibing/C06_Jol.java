package com.xicheng.javabase.mashibing;

import com.xicheng.javabase.common.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * description 参考：https://www.jianshu.com/p/6d62c3ee48d0
 *
 * @author xichengxml
 * @date 2020-10-09 22:29
 */
@Slf4j
public class C06_Jol {

    public static void main(String[] args) {
        A a = new A();
        LogUtil.info(log, "a: {}", ClassLayout.parseInstance(a).toPrintable());
        B b = new B();
        LogUtil.info(log, "b: {}", ClassLayout.parseInstance(b).toPrintable());
        C c = new C();
        LogUtil.info(log, "c: {}", ClassLayout.parseInstance(c).toPrintable());

        int[] intArr01 = new int[0];
        LogUtil.info(log, "intArr01: {}", ClassLayout.parseInstance(intArr01).toPrintable());
        int[] intArr02 = new int[1];
        LogUtil.info(log, "intArr02: {}", ClassLayout.parseInstance(intArr02).toPrintable());
        long[] longArr = new long[0];
        LogUtil.info(log, "longArr: {}", ClassLayout.parseInstance(longArr).toPrintable());

    }

    static class A {

    }

    static class B {
        private long salary;
    }

    static class C {
        private long salary;

        private int age;
    }
}


