package com.wanyue.method;

/*
礼让线程
自己从cpu中出来，重新竞争
礼让不一定成功，看cpu心情
 */
public class TestYield {
     public static void main(String[] args) {
         new Thread(new MyYield(),"aaa").start();
         new Thread(new MyYield(),"bbb").start();
      }

}

class MyYield implements  Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程结束执行");
    }
}
