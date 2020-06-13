package com.xicheng.javabase.t04_generics;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * description 使用泛型定义只能传输的类型
 *
 * @author xichengxml
 * @date 2020-06-13 23:24
 */
@Getter
@Setter
@Slf4j
public class C03_Holder<T> {

    private T specificType;

    public static void main(String[] args) {
        C03_Holder<String> stringHolder = new C03_Holder<>();
        stringHolder.setSpecificType("only string");
        log.info(stringHolder.getSpecificType());
    }
}
