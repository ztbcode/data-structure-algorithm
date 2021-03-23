package com.company.linked;

/**
 * @Description: 链表节点$
 * @Author: shulin
 * @date: 2020/9/4
 */
public class SingleNode {
    private int data;
    //指向下一个节点指针
    private SingleNode next;

    public int getData(){
        return this.data;
    }
    public void setData(int data){
        this.data = data;
    }
    public SingleNode getNext(){
        return  this.next;
    }
    public void setNext(SingleNode next){
        this.next = next;
    }
    public SingleNode(int data){
        this.data = data;
    }
    public SingleNode(){

    }
}

