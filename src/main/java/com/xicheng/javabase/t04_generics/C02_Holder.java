package com.xicheng.javabase.t04_generics;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * description 使用Object支持保存多个类型
 *
 * @author xichengxml
 * @date 2020-06-13 23:18
 */
@Setter
@Getter
@Slf4j
public class C02_Holder {

    private Object anything;

    public static void main(String[] args) {
        C02_Holder holder = new C02_Holder();
        holder.setAnything("a string");
        String string = (String) holder.getAnything();
        log.info("string: {}", string);

        holder.setAnything(1);
        Integer integer = (Integer) holder.getAnything();
        log.info("integer: {}", integer);
    }
}
