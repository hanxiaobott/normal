package com.example.self.normalpractice.suanfa2;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-04 13:53
 */
public class IsAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-anagram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        String s = "rat", t = "cat";
        System.out.println(isAnagram(s, t));
    }

    /**
     * 思路是使用map
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> tempMap = Maps.newHashMap();
        if(s.length() != t.length()){
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer cTimes = tempMap.get(c);
            tempMap.put(c,cTimes == null ? 1 : cTimes + 1);
            if(tempMap.get(c) == 0){
                tempMap.remove(c);
            }

            char b = t.charAt(i);
            Integer bTimes = tempMap.get(b);
            tempMap.put(b,bTimes == null ? -1 : bTimes - 1);

            if(tempMap.get(b) == 0){
                tempMap.remove(b);
            }
        }
        return tempMap.isEmpty();

    }

}
