package com.example.self.normalpractice.suanfa2;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-05 17:18
 */
public class ReverseBinaryTree {

    /**
     * 翻转一棵二叉树。
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
        invertTree(ListNode1);

        System.out.println(ListNode1);
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null){
            invertTree(root.left);
        }
        if(root.right != null){
            invertTree(root.right);
        }

        return root;
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
