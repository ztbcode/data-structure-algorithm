package com.company.thread;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 线程测试$
 * @Author: shulin
 * @date: 2020/9/17
 */
public class ThreadTest {
    public static void main(String[] args) {
/*        ThreadOperator threadOperator = new ThreadOperator();
        threadOperator.print();*/
/*        ThreadAtomicOperator threadAtomicOperator = new ThreadAtomicOperator();
        threadAtomicOperator.print();*/
        int[] arr = {1,1,2,3,4,5,3,3,23434};
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.setArr(arr);
        try {
            threadDemo.count();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 构建多值Map样例代码
/*        Map<Integer, AtomicInteger> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.computeIfAbsent(1,key ->new AtomicInteger()).getAndIncrement();
        concurrentHashMap.computeIfAbsent(1,key ->new AtomicInteger()).getAndIncrement();
        concurrentHashMap.computeIfAbsent(2,key ->new AtomicInteger()).getAndIncrement();
        System.out.println(concurrentHashMap);*/

    }

    static HashSet<String> genValue(String str) {
        return new HashSet<String>();
    }

}

