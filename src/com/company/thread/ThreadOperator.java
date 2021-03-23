package com.company.thread;

/**
 * @Description: 多线程实现顺序打印1到100$
 * @Author: shulin
 * @date: 2020/9/17
 */
public class ThreadOperator {
    //当前打印的数
    private volatile int i = 1;
    //标志 可以看做一把锁
    private volatile int flag = 0;

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
            while (i <= 100){
                if(flag == 0){
                    System.out.println(Thread.currentThread().getName()+" "+i);
                    i++;
                    flag = 1;
                }
            }
        }
    }
    public class MyThread2 implements Runnable{
        @Override
        public void run() {
            while (i <= 100){
                if(flag == 1){
                    System.out.println(Thread.currentThread().getName()+" "+i);
                    i++;
                    flag = 2;
                }
            }
        }
    }
    public class MyThread3 implements Runnable{
        @Override
        public void run() {
            while (i <= 100){
                if(flag == 2){
                    System.out.println(Thread.currentThread().getName()+" "+i);
                    i++;
                    flag = 0;
                }
            }
        }
    }
}

