package com.xicheng.javabase.t04_generics;

import com.xicheng.javabase.common.GenericsConstant;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-14 09:19
 */
@Slf4j
public class C07_RandomList<T> {

    private List<T> list = new ArrayList<>();

    private Random random = new Random(47);

    public void add(T t) {
        list.add(t);
    }

    public T select() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        C07_RandomList<String> randomList = new C07_RandomList<>();
        for (String s : GenericsConstant.STRING.split(" ")) {
            randomList.add(s);
        }

        log.info(randomList.select());
    }
}
