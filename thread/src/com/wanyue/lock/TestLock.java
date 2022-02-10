package com.wanyue.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        Qiang qiang = new Qiang();
        new Thread(qiang).start();
        new Thread(qiang).start();
        new Thread(qiang).start();
    }

}

class Qiang implements Runnable{
    int ticNums = 10;

    //显式的锁，可重入锁，一般都加 private final 修饰，与try配合使用
    //ReentrantLock和synchronized都是可重入锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try {
                lock.lock();
                if(ticNums>0){
                    ticNums--;
                    System.out.println(ticNums);
                } else{
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}