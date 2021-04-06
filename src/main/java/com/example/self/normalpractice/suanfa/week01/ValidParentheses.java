package com.example.self.normalpractice.suanfa.week01;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description:  有效括号
 * @author: hanxiaobo
 * @create: 2021-04-06 16:23
 */
public class ValidParentheses {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * @param args
     */
    public static void main(String[] args) {
        String s = "()[]}";
        System.out.println(isValid(s));
    }

    public  static  boolean isValid1(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        Map<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");

        Stack<String> stack = new Stack<>();

        for (int i = s.length() -1 ; i >= 0; i--) {
            String element = s.substring(i, i +1);
            if(null == map.get(element)){
                stack.push(element);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                String pop = stack.pop();

                if(null == pop || !pop.equals(map.get(element))){
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if (c == '{'){
                stack.push('}');
            }else {
                if(stack.isEmpty()){
                    return false;
                }

                if(c != stack.pop()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
