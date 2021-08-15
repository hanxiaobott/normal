package com.example.self.normalpractice.suanfa2;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
*      * 实现 LRUCache 类：
*      * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
*      * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
*      * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，
*      * 则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
*      * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
*      * 来源：力扣（LeetCode）
*      * 链接：https://leetcode-cn.com/problems/lru-cache
*      * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *      [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
*      * @param args
 * @author: hanxiaobo
 * @create: 2021-08-12 14:39
 */
public class LRUCache {


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));


    }

    Map<Integer, LruNode> map = new HashMap<>();

    // 虚拟头节点
    LruNode head;

    // 虚拟未节点
    LruNode tail;

    Integer capacity ;

    Integer size ;

    class LruNode{

        LruNode prev;
        LruNode next;
        int key;
        int value;

        LruNode(){
        }

        LruNode(Integer key ,Integer value){
            this.key = key;
            this.value = value;
        }

    }

    public LRUCache(int capacity) {
        this.size = 0;
        head = new LruNode();
        tail = new LruNode();

        head.next = tail;
        tail.prev = head;

        this.capacity = capacity;
    }

    public int get(int key) {
        // 不存在是-1
        LruNode lruNode = map.get(key);
        if(lruNode == null){
            return -1;
        }

        // 当前节点从列表中删除
        removeNode(lruNode);

        // 存在，移动到头结点
        moveNodeToHead(lruNode);
        return lruNode.value;
    }

    public void put(int key, int value) {
        LruNode lruNode = map.get(key);

        // 节点存在
        if(lruNode != null){
            lruNode.value = value;

            // 当前节点从列表中删除
            removeNode(lruNode);

            // 移动到头结点
            moveNodeToHead(lruNode);
            return;
        }

        // 节点不存在
        LruNode newLruNode = new LruNode(key,value);

        // 大于容量删除
        if(size == capacity){
            LruNode tailPreTemp = tail.prev;
            removeNode(tailPreTemp);
            // 从map中删除
            map.remove(tailPreTemp.key);
            size --;
        }

        // 新节点插入头部
        moveNodeToHead(newLruNode);

        // 新节点放入map
        map.put(key, newLruNode);
        size ++ ;

    }

    private void removeNode(LruNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    private void moveNodeToHead(LruNode node){

        // 当前节点的下一个节点是头节点的下一个节点
        node.next = head.next;

        // 头节点下一个节点的前一个节点是当前节点
        head.next.prev = node;

        // 头节点的下一个节点是当前节点
        head.next = node;

        // 当前节点的前一个节点是头节点
        node.prev = head;


    }

}
