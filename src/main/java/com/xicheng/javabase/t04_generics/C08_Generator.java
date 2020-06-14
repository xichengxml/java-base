package com.xicheng.javabase.t04_generics;

/**
 * description 生成器基础接口
 *
 * @author xichengxml
 * @date 2020-06-14 10:03
 */
public interface C08_Generator<S, T> {

    T generate(S s);
}
