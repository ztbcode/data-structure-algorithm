package com.company_test1.linked;

import java.util.Hashtable;

/**
 * @Description: 单链表操作$
 * @Author: shulin
 * @date: 2020/9/4
 */
public class SingleLinkedListDemo {
    private SingleNode head = null;

    //添加链表节点 在头结点后面
    public void addHead(int data) {
        SingleNode newNode = new SingleNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        SingleNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(newNode);
    }

    //链表结点 在头结点前面
    public void addTail(SingleNode node) {
        if (head == null) {
            head = node;
        }
        node.setNext(head);
        head = node;
    }

    //获取下标为k的节点
    public SingleNode getByIndex(int k) {
        SingleNode tempNode = this.head;
        if (k < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else if(k == 0){
            return tempNode;
        } else {
            for (int i = 1; i < k; i++) {
                if (tempNode == null) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                tempNode = tempNode.getNext();
            }
        }
        return tempNode;
    }

    //删除下标为k的结点
    public void delete(int k) {
        SingleNode currentNode = this.head;
        SingleNode next = currentNode.getNext();
        if (k < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (k == 0) {
            head = head.getNext();
            return;
        } else if (k == 1){
            currentNode.setNext(next.getNext());
            return;
        } else {
            for (int i = 1; i < k; i++) {
                if (next == null){
                    throw new ArrayIndexOutOfBoundsException();
                }
                currentNode = currentNode.getNext();
                next = next.getNext();
            }
        }
        currentNode.setNext(next.getNext());
    }
    //在下标为k的位置添加节点
    public void add(int k ,SingleNode singleNode){
        SingleNode currentNode = this.head;
        if (k < 0){
            throw new ArrayIndexOutOfBoundsException();
        }else if (k == 0){
            singleNode.setNext(this.head);
            this.head = singleNode;
            return;
        }
        int j = 1;
        while (j < k){
            currentNode = currentNode.getNext();
            j++;
        }
        singleNode.setNext(currentNode.getNext());
        currentNode.setNext(singleNode);
    }

    //打印链表节点
    public void printNode() {
        SingleNode tempNode = this.head;
        while (tempNode != null) {
            System.out.println(tempNode.getData() + ",");
            tempNode = tempNode.getNext();
        }
        System.out.println("-----------------");
    }

    //求链表长度
    public int getLength(SingleNode singleNode) {
        SingleNode head = singleNode;
        int i = 0;
        while (head != null) {
            i++;
            head = head.getNext();
        }
        return i;
    }
    //排序节点
    public void sort(){
        if (head == null){
            return;
        }
        SingleNode currentNode = this.head;
        while (currentNode !=null){
            SingleNode next = currentNode.getNext();
            while (next!=null){
                int temp;
                if (currentNode.getData()>next.getData()){
                    temp =  next.getData();
                    next.setData(currentNode.getData());
                    currentNode.setData(temp);
                }
                next = next.getNext();
            }
            currentNode= currentNode.getNext();
        }
    }
    //链表反转
    public SingleNode reversal(SingleNode node){
        if (node == null || node.getNext() == null){
            return node;
        }
        SingleNode preNode = node;  //前驱节点
        SingleNode currentNode = node.getNext(); //当前节点
        SingleNode tempNode; //当前节点的下一个节点
        while (currentNode != null){
            tempNode = currentNode.getNext(); //因为待会currentNode的下一个节点会改变，所以需要一个临时节点来存储
            currentNode.setNext(preNode);
            preNode = currentNode;
            currentNode = tempNode;
        }
        node.setNext(null);
        return preNode;
    }
    //去掉重复元素 需要额外的存储空间 通过调用hashtable.containsKey()来判断重复结点
    public void distinct() {
        SingleNode currentNode = this.head;
        SingleNode preNode = null;
        Hashtable<Integer, Integer> hb = new Hashtable<Integer, Integer>();
        while (currentNode!=null){
            if (hb.contains(currentNode.getData())){
                preNode.setNext(currentNode.getNext());
            }else {
                hb.put(currentNode.getData(),1);
                preNode = currentNode;
            }
            currentNode = currentNode.getNext();
        }
    }
    //返回倒数第k个节点 两个指针      * 两个指针，第一个指针向前移动k-1次，之后两个指针共同前进，
    //     * 当前面的指针到达末尾时，后面的指针所在的位置就是倒数第k个位置
    public SingleNode findReverNode(int k){
        if (k<1){
            return null;
        }
        SingleNode first = this.head;
        SingleNode second = this.head;
        int i = 1;
        while (i < k){
            first = first.getNext();
            i++;
        }
        while (first.getNext()!=null){
            second =  second.getNext();
            first = first.getNext();
        }
        return second;
    }
    //寻找单链表的中间节点
    //用两个指针 1快1慢      * 快指针每次向前移动2个结点，慢指针一次向前移动一个结点，
    //     * 当快指针移动到链表的末尾，慢指针所在的位置即为中间结点所在的位置
    //当链表节点个数是奇数时，返回中间节点，当链表个数是偶数时，返回中间的第一个节点
    public SingleNode findMiddleNode(){
        SingleNode fast = this.head;
        SingleNode slow = this.head;
        while (fast.getNext()!=null&&fast.getNext().getNext()!=null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
    //判断链表是否有环
    public boolean isRinged(){
        if (head == null){
            return false;
        }
        SingleNode fast = this.head;
        SingleNode slow = this.head;
        while (fast.getNext()!=null&&fast.getNext().getNext()!=null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast.getData() == slow.getData()){
                return true;
            }
        }
        return false;
    }
    /**
     * 在不知道头结点的情况下删除指定结点：
     * 删除结点的重点在于找出其前结点，使其前结点的指针指向其后结点，即跳过待删除结点
     * 1、如果待删除的结点是尾结点，由于单链表不知道其前结点，没有办法删除
     * 2、如果删除的结点不是尾结点，则将其该结点的值与下一结点交换，然后该结点的指针指向下一结点的后续结点
     */
    public boolean deleteSpecialNode(SingleNode node){
        if (node.getNext() == null){
            return false;
        }
        int temp = node.getNext().getData();
        node.getNext().setData(node.getData());
        node.setData(temp);
        node.setNext(node.getNext().getNext());
        return true;
    }
    /**
     * 判断两个链表是否相交：
     * 两个链表相交，则它们的尾结点一定相同，比较两个链表的尾结点是否相同即可
     */
    public boolean isCross(SingleNode node1,SingleNode node2){
        SingleNode tempNode1 = node1;
        SingleNode tempNode2 = node2;
        while (tempNode1.getNext()!=null){
            tempNode1 = tempNode1.getNext();
        }
        while (tempNode2.getNext()!=null){
            tempNode2 = tempNode2.getNext();
        }
        if (tempNode1.getData() == tempNode2.getData()){
            return true;
        }
        return false;
    }
    /**
     * 如果链表相交，求链表相交的起始点：
     * 1、首先判断链表是否相交，如果两个链表不相交，则求相交起点没有意义
     * 2、求出两个链表长度之差：len=length1-length2
     * 3、让较长的链表先走len步
     * 4、然后两个链表同步向前移动，没移动一次就比较它们的结点是否相等，第一个相等的结点即为它们的第一个相交点
     */
    public SingleNode findFirstCrossPoint(SingleNode singleNode1, SingleNode singleNode2){
        //链表不相交
        if(!isCross(singleNode1,singleNode2)){
            return null;
        }else{
            int length1 = getLength(singleNode1); //链表1的长度
            int length2 = getLength(singleNode2); //链表2的长度
            int len = length1 - length2;//链表1和链表2的长度差
            SingleNode tempNode1 = singleNode1;
            SingleNode tempNode2 = singleNode2;
            if(len > 0){//链表1比链表2长，链表1先前移len步
                for(int i=0; i<len; i++){
                    tempNode1 = tempNode1.getNext();
                }
            }else{//链表2比链表1长，链表2先前移len步
                for(int i=0; i<len; i++){
                    tempNode2 = tempNode2.getNext();
                }
            }
            //链表1和链表2同时前移,直到找到链表1和链表2相交的结点
            while(tempNode1.getData() != tempNode2.getData()){
                tempNode1 = tempNode1.getNext();
                tempNode2 = tempNode2.getNext();
            }
            return tempNode1;
        }
    }


}

