package com.example.self.normalpractice.suanfa2;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrderBinaryTree {

    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
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

        List<List<Integer>> lists = levelOrder(ListNode1);
        System.out.println(lists);

    }

    /**
     * 当前要poll的次数，就是当前的队列的size
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> list = new LinkedList<>();
        List<List<Integer>> result = Lists.newArrayList();
        list.offer(root);

        while (!list.isEmpty()){
            int size = list.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode poll = list.poll();
                temp.add(poll.val);
                if(poll.left != null){
                    list.offer(poll.left);
                }

                if(poll.right != null){
                    list.offer(poll.right);
                }
            }

            result.add(temp);
        }

        return result;

    }

    public static void bfs(TreeNode root, List<List<Integer>> result){

    }


    @Data
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
