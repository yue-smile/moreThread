package com.wanyue.method;


//创建线程方式二 实现runnable接口，重写run方法，执行线程需要丢入runable接口实现类，调用start方法

//推荐使用实现Runnable接口的方式创建线程，因为继承Thread类存在单继承的问题，不能再继承其他类，方便同一个对象被多个线程使用

public class TestStop implements Runnable {

    boolean flag = true;

    @Override
    public void run() {
        while(flag == true){
            for(int i=0;i<10000;i++){
                System.out.println("我是线程01！");
            }
        }
    }

    //已经不再使用Thread的destory和stop方法，目前建议使用标志位，是线程自动运行到停止
    void stop(){
        this.flag = false;
    }

     public static void main(String[] args) {
         TestStop thread02 = new TestStop();
         Thread thread = new Thread(thread02);
         thread.start();

         for(int i=0;i<10000;i++){
             if(i==5000){
                 //使用标志位停止线程
                 thread02.stop();
                 System.out.println("线程标志位转换，该停止了");
             }
             System.out.println("我是主线程");
         }

     }

}
