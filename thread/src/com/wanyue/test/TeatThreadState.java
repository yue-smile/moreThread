package com.wanyue.test;

/*
NEW                 创建
TIMED_WAITING       就绪
RUNNABLE            运行
BLOCKED             阻塞
TERMINATED          销毁
当线程状态为阻塞之后就不能再进行start启动
 */
public class TeatThreadState {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i=0;i<10;i++){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我爱你"+i);
            }
        });
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        while (thread.getState()!= Thread.State.TERMINATED){
            System.out.println(thread.getState());
        }
        System.out.println(thread.getState());

    }

}
