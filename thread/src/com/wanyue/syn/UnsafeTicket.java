package com.wanyue.syn;

public class UnsafeTicket implements Runnable{
    //票数  int存在线程安全问题
    private Integer ticketNums = 100;

    @Override
    public void  run() {
        while(ticketNums>0){
            buy();
        }
    }

    //同步方法，同步方法会对this上锁。 独占锁
    public synchronized void buy(){
        if(ticketNums>0){
            System.out.println(Thread.currentThread().getName()+"抢到了第"+ticketNums+"张票");
            ticketNums--;
        }
    }

    public static void main(String[] args) {
        UnsafeTicket qiangpiao = new UnsafeTicket();
        new Thread(qiangpiao,"张三").start();
        new Thread(qiangpiao,"李四").start();
        new Thread(qiangpiao,"王五").start();
    }
}
