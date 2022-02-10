package com.wanyue.create;


//创建线程方式二 实现runnable接口，重写run方法，执行线程需要丢入runable接口实现类，调用start方法

//推荐使用实现Runnable接口的方式创建线程，因为继承Thread类存在单继承的问题，不能再继承其他类，方便同一个对象被多个线程使用

public class Thread02 implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            System.out.println("我是线程01！");
        }
    }

     public static void main(String[] args) {
         Thread02 thread02 = new Thread02();
         Thread thread = new Thread(thread02);
         thread.start();
         for(int i=0;i<10000;i++){
             System.out.println("我是主线程");
         }
      }

}
