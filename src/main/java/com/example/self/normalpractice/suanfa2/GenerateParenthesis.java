package com.example.self.normalpractice.suanfa2;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-05 15:53
 */
public class GenerateParenthesis {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        method(0, 0, result, "", n);
        return result;
    }

    public static void method(int left, int right ,List<String> result, String current, int n){
        if(n == left && n == right){
            result.add(current);
            return;
        }

        if(left > n || right > n){
            return;
        }

        if(left < n){
            method(left + 1, right,result, current + "(", n);
        }

        if(right < n && left > right){
            method(left , right + 1, result,current + ")", n);
        }

    }

//    public static void method(int left, int right,List<String> result, int n, String current){
//        if(left > n || right > n){
//            return;
//        }
//        current = current + "(";
//        method(left + 1,right, result, n, current);
//
//        current = current + ")";
//        method(left,right + 1, result, n, current);
//    }



}
