package com.company.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 多线程实现顺序打印1到100$
 * @Author: shulin
 * @date: 2020/9/17
 */
public class ThreadAtomicOperator {
    //当前打印的数
    private AtomicInteger i = new AtomicInteger(0);
    private final int max = 100;
    public int getAndIncrement() {
        int currentValue = i.getAndIncrement();
        if (currentValue > max) {
            return -1;
        }
        return currentValue;
    }

    public void print(){
        Thread thread1 = new Thread(new MyThread1());
        Thread thread2 = new Thread(new MyThread2());
        Thread thread3 = new Thread(new MyThread3());
        thread1.start();
        thread2.start();
        thread3.start();
    }
    public class MyThread1 implements Runnable{
        @Override
        public void run() {
/*            while (i.get() < 100){
                System.out.println(Thread.currentThread().getName()+" "+i.incrementAndGet());
            }*/
/*            while (i.get()<=100){
                System.out.println(Thread.currentThread().getName()+" "+i.get());
                i.getAndIncrement();
            }*/
            while (i.get() < 200) {
                int andIncrement = getAndIncrement();
                System.out.println(Thread.currentThread().getName() + " " + andIncrement);
            }

        }
    }
    public class MyThread2 implements Runnable{
        @Override
        public void run() {
/*            while (i.get() < 100){
                System.out.println(Thread.currentThread().getName()+" "+i.incrementAndGet());
            }*/
/*            while (i.get()<=100){
                System.out.println(Thread.currentThread().getName()+" "+i.get());
                i.getAndIncrement();
            }*/
            while (i.get() < 200) {
                int andIncrement = getAndIncrement();
                System.out.println(Thread.currentThread().getName() + " " + andIncrement);
            }
        }
    }
    public class MyThread3 implements Runnable{
        @Override
        public void run() {
/*            while (i.get() < 100){
                System.out.println(Thread.currentThread().getName()+" "+i.incrementAndGet());
            }*/
/*            while (i.get()<=100){
                System.out.println(Thread.currentThread().getName()+" "+i.get());
                i.getAndIncrement();
            }*/
            while (i.get() < 200) {
                int andIncrement = getAndIncrement();
                System.out.println(Thread.currentThread().getName() + " " + andIncrement);
            }
        }
    }
}

