package com.company.thread;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 数组统计多线程$
 * @Author: shulin
 * @date: 2020/9/22
 */
public class ThreadDemo {
    //记录数组当前位置
    private  AtomicInteger i = new AtomicInteger(0);
    //定义一个map key为变量 value为数字出现的次数
    private ConcurrentHashMap<Integer,AtomicInteger> concurrentHashMap = new ConcurrentHashMap<>();
    private int[] arr;

    public ConcurrentHashMap<Integer, AtomicInteger> getConcurrentHashMap() {
        return concurrentHashMap;
    }

    public void setConcurrentHashMap(ConcurrentHashMap<Integer, AtomicInteger> concurrentHashMap) {
        this.concurrentHashMap = concurrentHashMap;
    }

    public AtomicInteger getI() {
        return i;
    }

    public void setI(AtomicInteger i) {
        this.i = i;
    }
    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void count() throws InterruptedException {
        Thread thread1 = new Thread(new Mythread());
        Thread thread2 = new Thread(new Mythread());
        Thread thread3 = new Thread(new Mythread());
        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(100l);
        concurrentHashMap.forEach((k,v)->
                System.out.println(k+"出现的次数为"+v)
        );
    }

    public class Mythread implements Runnable{
        @Override
        public void run() {
            int index = 0;
            while ((index = i.getAndIncrement()) < arr.length){
                concurrentHashMap.computeIfAbsent(arr[index],
                        key -> new AtomicInteger()).getAndIncrement();
            }
        }
    }

}

