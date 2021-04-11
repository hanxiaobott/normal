package com.example.self.normalpractice.suanfa.week02;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 有效的字母异位词
 * @author: hanxiaobo
 * @create: 2021-04-11 13:27
 */
public class ValidAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * s = "anagram", t = "nagaram" true
     * s = "rat", t = "car" false
     * @param args
     */
    public static void main(String[] args) {
        String s = "rat";
        String t = "cat";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            Integer scCount = map.get(sc);
            scCount = (null == scCount? 1 : scCount + 1);
            map.put(sc, scCount);

            if(map.get(sc) == 0 ){
                map.remove(sc);
            }

            char tc = t.charAt(i);
            Integer tcCount = map.get(tc);
            tcCount = (null == tcCount? -1 : tcCount - 1);
            map.put(tc, tcCount);

            if(map.get(tc) == 0){
                map.remove(tc);
            }


        }

        return map.isEmpty();

    }
}
