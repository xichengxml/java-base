package com.xicheng.javabase.t04_generics;

import lombok.Getter;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-14 10:18
 */
@Getter
public enum C08_CoffeeCategoryEnum {

    MOCHA("Mocha", "摩卡咖啡"),

    CAPPUCCINO("Cappuccino", "卡布奇诺");

    private String code;

    private String cnName;

    C08_CoffeeCategoryEnum(String code, String cnName) {
        this.code = code;
        this.cnName = cnName;
    }
}
