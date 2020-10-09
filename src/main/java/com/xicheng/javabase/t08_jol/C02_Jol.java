package com.xicheng.javabase.t08_jol;

import com.xicheng.javabase.common.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-10-09 22:39
 */
@Slf4j
public class C02_Jol {

    public static void main(String[] args) {
        A a = new A();
        LogUtil.info(log, "a: {}", ClassLayout.parseInstance(a).toPrintable());
        synchronized (a) {
            LogUtil.info(log, "synchronized a: {}", ClassLayout.parseInstance(a).toPrintable());
        }
    }

    static class A {

    }
}
