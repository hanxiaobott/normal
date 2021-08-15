package com.example.self.normalpractice.suanfa2;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-04 13:36
 */
public class PlusOne {

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plus-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = {9, 9, 9, 9, 9, 9, 9};
        for (int j = 0; j < ints.length; j++) {
            System.out.print(ints[j] + "->");
        }

        int[] ints1 = plusOne(ints);
        System.out.println();

        for (int j = 0; j < ints1.length; j++) {
            System.out.print(ints1[j]+ "->");
        }
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1 ; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            if(digits[i] != 10){
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }


}
