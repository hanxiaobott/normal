package com.example.self.normalpractice.suanfa2;

import lombok.Data;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-03 09:19
 */
public class JiaoHuanLianBiao {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。(递归，也可以用非递归，非递归的方式不太会
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode ListNode1 = new ListNode(1);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode3 = new ListNode(3);
        ListNode ListNode4 = new ListNode(4);
        ListNode3.next = ListNode4;
        ListNode2.next = ListNode3;
        ListNode1.next = ListNode2;

        sout(ListNode1);
        ListNode listNode = swapPairs2(ListNode1);
        System.out.println();
        sout(listNode);
    }

    public static void sout(ListNode node){
        ListNode temp = node;
        while (temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }

    public static  ListNode reverse(ListNode head){
        ListNode result = null;
        ListNode temp = head;
        while (temp != null){
            ListNode next = temp.next;
            temp.next = result;

            result = temp;
            temp = next;
        }
        return result;
    }

    /**
     * 总结:链表的思路就是把要处理的节点先暂存，就是下边的next和nextNext，存下来以后temp就可以随意处理了
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {
        ListNode temp = head;
        if(temp == null){
            return null;
        }

        ListNode next = temp.next;
        if(next == null){
            return next;
        }

        ListNode nextNext = temp.next.next;

        temp.next = swapPairs2(nextNext);
        next.next = temp;
        return next;
    }



    @Data
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
