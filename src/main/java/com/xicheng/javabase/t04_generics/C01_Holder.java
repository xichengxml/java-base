package com.xicheng.javabase.t04_generics;

import lombok.Getter;
import lombok.Setter;

/**
 * description 只能保存单个类型
 *
 * @author xichengxml
 * @date 2020-06-13 23:15
 */
@Getter
@Setter
public class C01_Holder {

    private SpecificClass specificClass;

    static class SpecificClass {

    }
}
