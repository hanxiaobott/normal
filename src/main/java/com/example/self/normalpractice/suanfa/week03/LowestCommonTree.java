package com.example.self.normalpractice.suanfa.week03;

import com.example.self.normalpractice.suanfa.week02.TreeNode;

/**
 * @description: 二叉树的最近公共祖先
 * @author: hanxiaobo
 * @create: 2021-04-18 19:03
 */
public class LowestCommonTree {

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * @param args
     */
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
