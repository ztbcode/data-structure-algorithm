package com.company_test1.linked;

/**
 * @Description: 双向链表节点$
 * @Author: shulin
 * @date: 2020/9/16
 */
public class DoublyNode {
    //数据
    private int data;
    //前驱指针
    private DoublyNode pre;
    //后向指针
    private DoublyNode next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyNode getPre() {
        return pre;
    }

    public void setPre(DoublyNode pre) {
        this.pre = pre;
    }

    public DoublyNode getNext() {
        return next;
    }

    public void setNext(DoublyNode next) {
        this.next = next;
    }

    public DoublyNode(int data) {
        this.data = data;
    }

    public DoublyNode(){

    }
}

