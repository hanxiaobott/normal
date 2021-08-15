package com.example.self.normalpractice.suanfa2;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-02 11:20
 */
public class CircoleNode2 {

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。（map或者双指针，双指针的方式不太会）
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
        ListNode4.next = ListNode2;

        ListNode flag = detectCycle(ListNode1);
        System.out.println();

    }

    public static void sout(ListNode node){
        ListNode temp = node;
        while (temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = Sets.newHashSet();
        while (head != null){
            if(set.contains(head)){
                return head;
            }

            set.add(head);
            head = head.next;
        }
        return null;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
