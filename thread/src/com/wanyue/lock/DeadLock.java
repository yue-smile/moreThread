package com.wanyue.lock;
//
public class DeadLock {
    public static void main(String[] args) {
        new Huazhuang("白雪公主",0).start();
        new Huazhuang("灰姑娘",1).start();
    }
}

//口红
class Kouhong{
}
//镜子
class Jingzi{
}
//化妆
class Huazhuang extends Thread{
    String name;
    int choose;
    //静态资源只有一份，一份才存在 抢占资源
    static Kouhong kouhong = new Kouhong();
    static Jingzi jingzi = new Jingzi();
    Huazhuang(String name,int choose){
        this.choose = choose;
        this.name = name;
    }

    @Override
    public void run(){
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void makeup() throws InterruptedException {
        if(choose==0){
            synchronized (kouhong){
                System.out.println(name+"拿到了口红，并锁住！等待镜子");
                Thread.sleep(100);
                synchronized (jingzi){
                    System.out.println(name+"拿到了镜子，化妆完成！");
                }
            }
        }else{
            synchronized (jingzi){
                System.out.println(name+"拿到了镜子，并锁住！等待口红");
                Thread.sleep(200);
                synchronized (kouhong){
                    System.out.println(name+"拿到了口红，化妆完成！");
                }
            }
        }
    }
    /* 解决方案
    void makeup() throws InterruptedException {
        if(choose==0){
            synchronized (kouhong){
                System.out.println(name+"拿到了口红，并锁住！等待镜子");
                Thread.sleep(100);
            }
            synchronized (jingzi){
                System.out.println(name+"拿到了镜子，化妆完成！");
            }
        }else{
            synchronized (jingzi){
                System.out.println(name+"拿到了镜子，并锁住！等待口红");
                Thread.sleep(200);
            }
            synchronized (kouhong){
                System.out.println(name+"拿到了口红，化妆完成！");
            }
        }
    }
     */

    /*
    产生死锁的四大必要条件：
    1 互斥条件：同一个资源同一时刻只能被一个线程使用
    2 阻塞保持条件：在自己线程被阻塞后依旧保持，不释放锁
    3 不强行剥夺条件：在自己线程被阻塞后依旧保持，不去强行抢占他人持有的锁
    4 相互等待：在若干线程之间形成头尾相接的循环资源等待关系
     */

}
