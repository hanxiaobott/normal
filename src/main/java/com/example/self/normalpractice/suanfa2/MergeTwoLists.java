package com.example.self.normalpractice.suanfa2;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-03 11:22
 */
public class MergeTwoLists {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。（哨兵，指针）
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

        ListNode ListNode5 = new ListNode(2);
        ListNode ListNode6 = new ListNode(3);
        ListNode ListNode7 = new ListNode(4);
        ListNode ListNode8 = new ListNode(5);
        ListNode7.next = ListNode8;
        ListNode6.next = ListNode7;
        ListNode5.next = ListNode6;

        sout(ListNode1);
        System.out.println();
        sout(ListNode5);
        ListNode listNode = mergeThreeList3(ListNode1,ListNode5);
        System.out.println();
        sout(listNode);

    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeThreeList3(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        if(l1.val <= l2.val){
            l1.next = mergeThreeList3(l1.next, l2);
            return l1;
        }

        l2.next = mergeThreeList3(l1, l2.next);
        return l2;

    }

    public static ListNode mergeTwoList2(ListNode l1, ListNode l2){
        // 定义一个哨兵
        ListNode result = new ListNode();

        // 定义一个指针，这个指针指向哨兵的最后一个节点，关键点就在这个指针上
        ListNode tempNode = result;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tempNode.next = l1;
                l1 = l1.next;
            }else {
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }

        tempNode.next = l1 == null ? l2 : l1;
        return result.next;

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode tempNode = result;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                tempNode.next = l1;
                l1 = l1.next;

            }else if(l1.val == l2.val){
                tempNode.next = l1;
                l1 = l1.next;
            }else {
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }
        tempNode.next = l1 == null ? l2:l1;

        return result.next;
    }

    public static void sout(ListNode node){
        ListNode temp = node;
        while (temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
