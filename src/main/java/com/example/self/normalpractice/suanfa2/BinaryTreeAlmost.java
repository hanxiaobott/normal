package com.example.self.normalpractice.suanfa2;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-05 17:48
 */
public class BinaryTreeAlmost {

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
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

    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return root;
        }

        if(p == root){
            return root;
        }
        if(q == root){
            return root;
        }

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;


    }

    /**
     * 中序遍历的思想
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null; // 如果树为空，直接返回null
        if(root == p || root == q) return root; // 如果 p和q中有等于 root的，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        if(left == null) return right; // 如果在左子树中 p和 q都找不到，则 p和 q一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else if(right == null) return left; // 否则，如果 left不为空，在左子树中有找到节点（p或q），
            // 这时候要再判断一下右子树中的情况，如果在右子树中，p和q都找不到，则 p和q一定都在左子树中，左子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else return root; //否则，当 left和 right均不为空时，说明 p、q节点分别在 root异侧, 最近公共祖先即为 root
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
