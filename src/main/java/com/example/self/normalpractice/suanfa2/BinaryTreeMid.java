package com.example.self.normalpractice.suanfa2;

import com.google.common.collect.Lists;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-04 16:09
 */
public class BinaryTreeMid {

    /**
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     * @param args
     */
    public static void main(String[] args) {
        TreeNode ListNode1 = new TreeNode(1);
        TreeNode ListNode2 = new TreeNode(2);
        TreeNode ListNode3 = new TreeNode(3);
        TreeNode ListNode4 = new TreeNode(4);
        TreeNode ListNode5 = new TreeNode(5);
        TreeNode ListNode6 = new TreeNode(6);
        TreeNode ListNode7 = new TreeNode(7);

        ListNode1.left = ListNode2;
        ListNode1.right = ListNode3;

        ListNode2.left = ListNode4;
        ListNode2.right = ListNode5;

        ListNode3.left = ListNode6;
        ListNode3.right = ListNode7;

        List<Integer> integers = inorderTraversal2(ListNode1);
        System.out.println(integers);
    }

    /**
     * 栈的方式
     * @param node
     * @return
     */
    public static List<Integer> inorderTraversal1(TreeNode node) {
        List<Integer> result = Lists.newArrayList();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                TreeNode pop = stack.pop();
                result.add(pop.val);
                node = pop.right;
            }
        }
        return result;
    }

    public static List<Integer> inorderTraversal2(TreeNode node) {
        List<Integer> result = Lists.newArrayList();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty()|| node != null){
            if(node != null){
                result.add(node.val);
                if(node.right != null){
                    stack.push(node.right);
                }
                node = node.left;
            }else {
                node = stack.pop();
            }
        }
        return result;
    }

    public static List<Integer> inorderTraversal3(TreeNode node) {
        List<Integer> result = Lists.newArrayList();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (!stack.isEmpty()|| node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else {
                TreeNode pop = stack.pop();
                if(pop.right == null || pop.right == prev){
                    result.add(pop.val);
                    prev = pop;
                    node = null;
                }else {
                    stack.push(pop);
                    node = pop.right;
                }
            }

        }
        return result;
    }

    /**
     * 递归的方式
     * @param node
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> result = Lists.newArrayList();
        inorder(node,result);
        return result;
    }

    public static void inorder(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }

        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right,result);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
      }
  }
}
