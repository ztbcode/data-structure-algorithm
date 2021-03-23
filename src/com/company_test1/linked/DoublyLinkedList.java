package com.company_test1.linked;

/**
 * @Description: 双向链表$
 * @Author: shulin
 * @date: 2020/9/16
 */
public class DoublyLinkedList {
    //根据下标获取对应的节点并且返回  doublyNode 头结点 index 位置
    public DoublyNode getNode(DoublyNode doublyNode, int index) {
        if (index < 0) {
            return null;
        }
        DoublyNode tempNode = doublyNode;
        int i = 0;
        while (i < index) {
            if (tempNode.getNext() == null) {
                return null;
            }
            tempNode = tempNode.getNext();
            i++;
        }
        return tempNode;
    }
    //删除一个节点

    /**
     * @param doublyNode 需要删除的节点
     * @return
     */
    public void removeNode(DoublyNode doublyNode) {
        DoublyNode pre = doublyNode.getPre();
        DoublyNode next = doublyNode.getNext();
        if (pre == null && next == null) {
            doublyNode.setData(0);
        } else if (pre == null) {  //删除头结点
            next.setPre(pre);
        } else if (next == null) {  //删除尾结点
            pre.setNext(next);
        } else {
            next.setPre(pre);
            pre.setNext(next);
        }
        //移除删除节点的指向
        doublyNode.setPre(null);
        doublyNode.setNext(null);
    }
    /**
     * 在链表后面添加节点
     *@param head 链表
     *@param doublyNode 要添加的节点
     * @return
     */
    public DoublyNode add(DoublyNode head,DoublyNode doublyNode){
        DoublyNode tempNode = head;
        if (tempNode == null){
            return tempNode;
        }
        //找到最后一个节点
        while (tempNode.getNext()!=null){
            tempNode = tempNode.getNext();
        }
        tempNode.setNext(doublyNode);
        doublyNode.setPre(tempNode);
        doublyNode.setNext(null);
        return head;
    }

}

