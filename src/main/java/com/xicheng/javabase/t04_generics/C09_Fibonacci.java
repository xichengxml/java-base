package com.xicheng.javabase.t04_generics;

import lombok.extern.slf4j.Slf4j;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-14 10:48
 */
@Slf4j
public class C09_Fibonacci implements C09_Generator<Integer> {

    private static int count = 0;

    private static int fib(int n) {
        if (n < 2) {
            return 1;
        } else {
            return fib(n - 2) + fib(n - 1);
        }
    }

    protected static Integer next() {
        return fib(count++);
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            stringBuilder.append(next()).append(' ');
        }
        log.info("result: {}", stringBuilder.toString());
    }
}
