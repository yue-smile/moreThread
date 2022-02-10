package com.wanyue.test;

import java.util.concurrent.atomic.AtomicInteger;

//买火车票例子
public class Qiangpiao implements Runnable{
    //票数  int存在线程安全问题
   //private int ticketNums = 10;

    private AtomicInteger ticketNums = new AtomicInteger(10);

    @Override
    public void run() {
        while(ticketNums.get()>0){
            System.out.println(Thread.currentThread().getName()+"抢到了第"+ticketNums.decrementAndGet()+"张票");
        }
    }

    public static void main(String[] args) {
        Qiangpiao qiangpiao = new Qiangpiao();
        new Thread(qiangpiao,"张三").start();
        new Thread(qiangpiao,"李四").start();
        new Thread(qiangpiao,"王五").start();
        //发现问题：抢占资源时，存在资源错乱，并发的问题
    }
}
