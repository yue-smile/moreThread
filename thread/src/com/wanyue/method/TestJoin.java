package com.wanyue.method;

/*
合并线程，插队
待当前线程执行完之后，才能执行其他线程,vip
 */
public class TestJoin implements  Runnable{

    @Override
    public void run() {
        for(int i=0;i<1500;i++){
            System.out.println(i+"我是vip我来啦");
        }
    }

    public static void main(String[] args) {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for(int i=0;i<1500;i++){
            if(i==500){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(i+"我是主线程");
        }

    }

}
