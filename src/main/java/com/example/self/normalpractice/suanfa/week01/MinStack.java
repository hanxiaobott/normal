package com.example.self.normalpractice.suanfa.week01;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @description:最小栈
 * @author: hanxiaobo
 * @create: 2021-04-06 16:58
 */
public class MinStack {

    LinkedList<Integer> a;
    LinkedList<Integer> b;

    public MinStack() {
        a = new LinkedList<Integer>();
        b = new LinkedList<Integer>();
    }

    public void push(int val) {
        a.push(val);
        b.push(b.peek() == null ? val : Math.min(b.peek(), val));
    }

    public void pop() {
        a.pop();
        b.pop();
    }

    public int top() {
        return a.peek();
    }

    public int getMin() {
        return b.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}
