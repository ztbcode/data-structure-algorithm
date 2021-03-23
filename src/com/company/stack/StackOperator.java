package com.company.stack;

import java.util.LinkedList;

/**
 * @Description: 栈操作类$
 * @Author: shulin
 * @date: 2020/9/16
 */
public class StackOperator {
    //实现O(1)时间复杂度的push pop 找到栈的最小元素
    //使用一个辅助栈 当往数据栈中push一个元素时，比较当前数据与辅助栈栈顶的大小，当前数据比辅助栈顶数据小压入辅助栈，
    // 当前数据比辅助栈顶数据大将辅助栈顶数据再次压入辅助栈 出栈时两者都出栈
    private LinkedList<Integer> dataStack;
    private LinkedList<Integer> minStack;
    public StackOperator(){
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    //入栈
    public void push(Integer data){
        dataStack.push(data);
        if (minStack.size() == 0 || data < minStack.peek()){
            minStack.push(data);
        }else {
            minStack.push(minStack.peek());
        }
    }
    //出栈
    public Integer pop(){
        if (dataStack.isEmpty()){
            return null;
        }
        Integer pop = dataStack.pop();
        minStack.pop();
        return pop;
    }
    //获取最小值
    public Integer min(){
        if (minStack.isEmpty()){
            return null;
        }
        return minStack.peek();
    }

}

