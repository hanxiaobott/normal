package com.example.self.normalpractice.suanfa2;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-04 14:57
 */
public class GroupAnagrams {

    /**
     * 给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词指字母相同，但排列不同的字符串。
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     * 时间复杂度：O(nklog⁡k)O(nk \log k)O(nklogk)，
     * 其中 nnn 是 strs\textit{strs}strs 中的字符串的数量，
     * kkk 是 strs\textit{strs}strs 中的字符串的的最大长度。
     * 需要遍历 nnn 个字符串，对于每个字符串，需要 O(klog⁡k)O(k \log k)O(klogk)
     * 的时间进行排序以及 O(1)O(1)O(1) 的时间更新哈希表，因此总时间复杂度是 O(nklog⁡k)O(nk \log k)O(nklogk)。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }


    /**
     * 思路。先排序
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> tempMap = Maps.newHashMap();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            List<String> list = tempMap.get(s);
            if(CollectionUtils.isEmpty(list)){
                list = new ArrayList<>();
                list.add(str);
                tempMap.put(s, list);
            }else {
                list.add(str);
            }

        }

        List<List<String>>  resut = new ArrayList<>();
        for (Map.Entry<String,List<String>> temp :tempMap.entrySet()) {
            resut.add(temp.getValue());
        }
        return resut;
    }
}
