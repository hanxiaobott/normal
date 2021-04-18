package com.example.self.normalpractice.suanfa.week03;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 括号生成
 * @author: hanxiaobo
 * @create: 2021-04-18 17:32
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        ArrayList<String> reuslt = new ArrayList<>();
        handle(reuslt, "", 3, 0, 0);
        for (String element : reuslt) {
            System.out.println(element);
        }
    }

    public static void handle(List<String> resultList,String result,int max, int zuo, int you){
        if(zuo == max && you == max){
            resultList.add(result);
            return;
        }

        if(zuo < max){
            handle(resultList, result + "(", max, zuo + 1,you);
        }

        if(zuo > you){
            handle(resultList, result + ")", max, zuo,you + 1);
        }
    }
}
