package com.wanyue.create;

//创建线程方式一: 继承Thread类，重写run方法，使用start开启
//线程开启不一定立即执行，由cpu调度安排
//直接调用run()并不开启多线程，调用start()为开启一个线程
public class Thread01 extends Thread {
    @Override
    public void run(){
        for(int i=0;i<10000;i++){
            System.out.println("我是线程01！");
        }
    }

    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        thread01.start();
        for(int i=0;i<10000;i++){
            System.out.println("我是主线程");
        }
    }

}
