package com.xicheng.javabase.t06_reference;

import com.xicheng.javabase.t06_reference.common.M;
import lombok.extern.slf4j.Slf4j;

/**
 * description 强引用
 *
 * @author xichengxml
 * @date 2020-09-28 23:44
 */
@Slf4j
public class C01_NormalReference {

    public static void main(String[] args) throws Exception {
        M m = new M();
        log.info("C01_NormalReference main before collect: {}", m);
        m = null;
        System.gc();
        log.info("C01_NormalReference main after collect: {}", m);

        // 阻塞等待
        System.in.read();
    }
}
