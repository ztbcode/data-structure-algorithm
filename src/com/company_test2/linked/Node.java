package com.company_test2.linked;

/**
 * @Description: 单链表节点$
 * @Author: shulin
 * @date: 2020/9/8
 */
public class Node {
    private int data;
    private Node next;
    public int getData(){
        return this.data;
    }
    public void setData(int data){
        this.data = data;
    }
    public Node getNext(){
        return this.next;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Node(int data){
        this.data = data;
    }
    public Node(){

    }
}

