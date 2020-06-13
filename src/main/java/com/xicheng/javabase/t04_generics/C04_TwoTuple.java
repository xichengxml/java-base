package com.xicheng.javabase.t04_generics;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * description 使用泛型支持return返回两个结果
 *
 * @author xichengxml
 * @date 2020-06-13 23:30
 */
@ToString
@Slf4j
public class C04_TwoTuple<A, B> {

    public final A first;

    public final B second;

    public C04_TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public static void main(String[] args) {
        C04_TwoTuple<String, Integer> result = returnTwoResult();
        log.info("first result: {}", result.first);
        log.info("second result: {}", result.second);
    }

    private static C04_TwoTuple<String, Integer> returnTwoResult() {
        String string = "string";
        Integer integer = 1;
        return new C04_TwoTuple<>(string, integer);
    }
}
