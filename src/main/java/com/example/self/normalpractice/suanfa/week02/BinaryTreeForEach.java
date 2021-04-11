package com.example.self.normalpractice.suanfa.week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 二叉树的遍历递归
 * @author: hanxiaobo
 * @create: 2021-04-11 14:11
 */
public class BinaryTreeForEach {

    public static void main(String[] args) {

    }

    public void qian(TreeNode node){
        System.out.println(node.val);
        if(node.left != null){
            qian(node.left);
        }
        if(node.right != null){
            qian(node.right);
        }
    }

    public void zhong(TreeNode node){
        if(node.left != null){
            zhong(node.left);
        }
        System.out.println(node.val);
        if(node.right != null){
            zhong(node.right);
        }
    }

    public void hou(TreeNode node){

        if(node.left != null){
            qian(node.left);
        }
        if(node.right != null){
            qian(node.right);
        }
        System.out.println(node.val);
    }

    public List<Integer> zhongFei(TreeNode node){
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (node != null || stack.size() > 0){
            if(node != null){
                // 根节点入栈
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }

        }
        return result;

    }

    public List<Integer> qianFei(TreeNode node){
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (node != null || !stack.isEmpty()){
            result.add(node.val);
            stack.push(node.right);

            if(node.left != null){
                node = node.left;
            }else {
                node = stack.pop();
            }

        }

        return result;

    }

    public List<Integer> houFei(TreeNode node){
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (node != null || stack.size() > 0){
            if(node != null){
                // 根节点入栈
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }

        }
        return result;

    }
}
