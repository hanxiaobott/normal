package com.example.self.normalpractice.suanfatop100;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-15 10:47
 */
public class TwoSum {


    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        LinkedList<Character> tempStack = new LinkedList();
        for(int i = s.length() - 1;i >= 0;i-- ){
            char tempChar = s.charAt(i);
            if (tempChar == ']' ){
                tempStack.push('[');
            }else if(tempChar == '}'){
                tempStack.push('{');
            }else  if(tempChar == ')'){
                tempStack.push('(');
            }else{
                if(tempStack.isEmpty()){
                    return false;
                }

                char popElement = tempStack.pop();
                if(tempChar != popElement){
                    return false;
                }
            }
        }
        return tempStack.isEmpty();
    }
}
