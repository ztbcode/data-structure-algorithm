package com.company_test2.linked;

/**
 * @Description: 链表操作类$
 * @Author: shulin
 * @date: 2020/9/8
 */
public class LinkedListOperator {
    //单链表翻转
    public Node reversal(Node node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        Node currentNode = node.getNext();  //当前节点
        Node preNode = node;  //前驱节点
        Node nextNode = null; //后续临时节点
        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(preNode);
            preNode = currentNode;
            currentNode = nextNode;
        }
        node.setNext(null);
        return preNode;
    }

    //链表中环的检测 两个指针，一个指针一次走两步 一个指针一次走一步 看存不存在相等情况
    public boolean isCross(Node node) {
        if (node == null) {
            return false;
        }
        Node fast = node;
        Node flow = node;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            flow = flow.getNext();
            if (fast.getData() == flow.getData()) {
                return true;
            }
        }
        return false;
    }

    //两个有序的链表合并
    public Node mergeTwoList(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        //取出node1和node2中头较小的链表
        Node node = node1.getData() > node2.getData() ? node2 : node1;
        //cur1表示头较小链表的引用
        Node cur1 = node == node1 ? node1 : node2;
        //cur2表示头较大链表的引用
        Node cur2 = node == node1 ? node2 : node1;
        //因为可能当前链表之前插入节点 所以需要一个前向临时指针
        Node pre = null;
        //因为可能在当前链表之后插入节点 所以需要一个后临时指针
        Node next = null;
        while (cur1 != null && cur2 != null) {
            //第一次必走此逻辑
            if (cur1.getData() < cur2.getData()) {
                pre = cur1;
                cur1 = cur1.getNext();
            } else {
                next = cur2.getNext();
                pre.setNext(cur2);
                cur2.setNext(cur1);
                pre = cur2;
                cur2 = next;
            }
        }
        pre.setNext(cur1 == null ? cur2 : cur1);
        return node;
    }
    //删除链表倒数第n个节点
    //先找到倒数第n+1个节点 然后让其指向第n-1个节点

    /**
     * 两个指针 先让第一个指针走n-1 再让两个指针一起走 当第一个指针走完 第二个指针的
     *
     * @param node 链表
     * @param n    第n个节点
     * @return
     */
    public boolean delete(Node node, int n) {
        int length = getLength(node);
        if (n == length) {
            node = node.getNext();
            return true;
        }
        Node reverNode = findReverNode(node, n + 1);
        if (reverNode == null) {
            return false;
        }
        reverNode.setNext(reverNode.getNext().getNext());
        return true;
    }

    //获取链表长度
    public int getLength(Node node) {
        if (node == null) {
            return 0;
        }
        int i = 1;
        while (node.getNext() != null) {
            i++;
        }
        return i;
    }

    //找到链表的倒数第n个节点 定义两个指针，让第一个指针先走n-1个节点 然后两个一起走 当第一个走到尾，第二个就是倒数第n个节点
    public Node findReverNode(Node node, int n) {
        if (n < 1) {
            return null;
        }
        int length = getLength(node);
        if (n > length) {
            return null;
        }
        Node first = node;
        Node second = node;
        int i = 1;
        while (i < n) {
            first = first.getNext();
        }
        while (first.getNext() != null) {
            first = first.getNext();
            second = second.getNext();
        }
        return second;
    }
    //求链表的中间节点 当链表是奇数时返回中间数 当链表是偶数时，返回中间较小的数
    //一个快指针 一次走两步 一个慢指针 一次走一步
    public Node findMiddleNode(Node node){
        if (node == null){
            return null;
        }
        Node fast = node;
        Node slow = node;
        while (fast.getNext()!=null&&fast.getNext().getNext()!=null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }

}

