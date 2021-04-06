package com.example.self.normalpractice.suanfa.week01;

import java.util.LinkedList;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-04-06 17:35
 */
public class Test {

    public static void main(String[] args) {
        LinkedList<String> stack = new LinkedList<>();
        stack.offer("a");
        stack.offer("b");
        stack.offer("c");
        stack.offer("d");
        stack.offer("e");
//        System.out.println(stack.pop());
        System.out.println(stack.poll());
    }
}
