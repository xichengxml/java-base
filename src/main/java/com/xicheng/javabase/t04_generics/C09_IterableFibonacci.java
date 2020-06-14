package com.xicheng.javabase.t04_generics;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-14 11:04
 */
@Slf4j
public class C09_IterableFibonacci extends C09_Fibonacci implements Iterable<Integer> {

    private int n;

    public C09_IterableFibonacci(int count) {
        this.n = count;
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : new C09_IterableFibonacci(18)) {
            stringBuilder.append(i).append(" ");
        }
        log.info("result: {}", stringBuilder.toString());
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return C09_IterableFibonacci.next();
            }
        };
    }
}
