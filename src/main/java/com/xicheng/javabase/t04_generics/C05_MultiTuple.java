package com.xicheng.javabase.t04_generics;

/**
 * description 扩展到可以支持多个返回类型
 *
 * @author xichengxml
 * @date 2020-06-13 23:38
 */
public class C05_MultiTuple {

    static class ThreeTuple<A, B, C> extends C04_TwoTuple<A, B> {

        public final C third;

        public ThreeTuple(A first, B second, C third) {
            super(first, second);
            this.third = third;
        }
    }

    static class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {

        public final D fourth;

        public FourTuple(A first, B second, C third, D fourth) {
            super(first, second, third);
            this.fourth = fourth;
        }
    }
}
