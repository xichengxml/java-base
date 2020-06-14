package com.xicheng.javabase.t04_generics;

import lombok.extern.slf4j.Slf4j;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-14 10:07
 */
@Slf4j
public class C08_Cappuccino implements C08_Coffee {

    @Override
    public void saySomething() {
        log.info("invoke CappuccinoBiz and do some biz thing");
    }
}
