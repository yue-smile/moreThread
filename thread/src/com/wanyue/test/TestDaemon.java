package com.wanyue.test;


//虚拟机不用等守护线程执行完毕，但是需要等待用户线程执行完毕

public class TestDaemon {
    public static void main(String[] args) {
        God god =  new God();
        Ren ren = new Ren();
        Thread threadGod = new Thread(god,"守护线程");
        Thread threadRen = new Thread(ren,"用户线程");
        threadGod.setDaemon(true);//设置为守护线程
        threadGod.start();
        threadRen.start();
    }
}


class God implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("上帝守护着你");
        }
    }
}
class Ren implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我活了"+i+"年");
        }
        System.out.println("goodbye!");
    }
}