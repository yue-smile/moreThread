package com.wanyue.method;

import com.wanyue.test.Qiangpiao;

//每个对象都有一把锁，sleep并不会释放锁

public class TestSleep implements Runnable{

    //票数  int存在线程安全问题
    private int ticketNums = 10;


    @Override
    public void run() {
        while(ticketNums>0){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticketNums--;
            System.out.println(Thread.currentThread().getName()+"抢到了第"+ticketNums+"张票");
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
