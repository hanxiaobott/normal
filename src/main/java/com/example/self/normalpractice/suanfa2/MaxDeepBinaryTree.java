package com.example.self.normalpractice.suanfa2;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-05 17:30
 */
public class MaxDeepBinaryTree {

    /**
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
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

        System.out.println(maxDepth(ListNode1));
        
    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int rignt = maxDepth(root.right);

        return left < rignt ? left + 1 : rignt + 1 ;
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
