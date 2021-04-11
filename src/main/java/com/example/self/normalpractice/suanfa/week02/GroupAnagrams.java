package com.example.self.normalpractice.suanfa.week02;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description: 字母异位词分组
 * @author: hanxiaobo
 * @create: 2021-04-11 13:38
 */
public class GroupAnagrams {

    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strings);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            String element = strs[i];
            char[] elementChars = element.toCharArray();
            Arrays.sort(elementChars);
            String s = String.valueOf(elementChars);
            if(map.get(s) != null){
                List<String> strings = map.get(s);
                strings.add(element);
            }else {
                List<String> list = new ArrayList<>();
                list.add(element);
                map.put(s, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entrySet : map.entrySet()) {
            result.add(entrySet.getValue());
        }
        return result;
    }

}
