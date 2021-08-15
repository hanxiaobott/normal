package com.example.self.normalpractice.suanfa2;

import lombok.Data;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-02 10:57
 */
public class CircleNode {

    /**
     * 给定一个链表，判断链表中是否有环。（快慢指针或者map）
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
        ListNode4.next = ListNode1;

//        sout(ListNode1);
        boolean flag = hasCycle(ListNode1);
        System.out.println();
        System.out.println(flag);

    }

    public static void sout(ListNode node){
        ListNode temp = node;
        while (temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null && slow.next !=null){
            fast = fast.next;
            slow = slow.next.next;
            if(fast == slow){
                return true;
            }
        }

        return false;
    }


    @Data
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }



}

