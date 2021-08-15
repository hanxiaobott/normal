package com.example.self.normalpractice.suanfa2;

import lombok.Data;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-02 10:08
 */
public class ReverseNode {
    public static void main(String[] args) {
        ListNode ListNode1 = new ListNode(1);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode3 = new ListNode(3);
        ListNode ListNode4 = new ListNode(4);
        ListNode3.next = ListNode4;
        ListNode2.next = ListNode3;
        ListNode1.next = ListNode2;

        sout(ListNode1);
        ListNode listNode = reverseList2(ListNode1);
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

    public static ListNode reverseList2(ListNode head){
        ListNode cur = head;
        ListNode result = null;
        while (cur != null){
            ListNode tempNode = cur.next;
            cur.next = result;

            result = cur;
            cur = tempNode;

        }
        return result;
    }






    public static ListNode reverseList(ListNode head) {

        // 当前要遍历的节点
        ListNode cur = head;

        // 要指向的节点
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next  = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    @Data
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
