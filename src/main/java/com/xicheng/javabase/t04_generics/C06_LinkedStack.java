package com.xicheng.javabase.t04_generics;

import com.xicheng.javabase.common.GenericsConstant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-06-14 07:33
 */
@Slf4j
public class C06_LinkedStack<T> {

    public static void main(String[] args) {
        C06_LinkedStack<String> linkedStack = new C06_LinkedStack<>();
        for (String s : GenericsConstant.STRING.split(" ")) {
            linkedStack.push(s);
        }

        String top;
        while ((top = linkedStack.pop()) != null) {
            log.info("top: {}", top);
        }
    }

    /**
     * 末端哨兵
     */
    private Node<T> top = new Node<>();

    public void push(T t) {
        top = new Node<>(t, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    @AllArgsConstructor
    private static class Node<U> {
        U item;
        Node<U> next;

        public Node() {
            item = null;
            next = null;
        }

        boolean end() {
            return item == null && next == null;
        }
    }
}
