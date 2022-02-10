package com.wanyue.together;

//生产者消费者模型 信号灯法   做一个吃一个
public class TestPC2 {
    public static void main(String[] args) {
        Canting canting = new Canting();
        new Xiaofei(canting).start();
        new Shengchan(canting).start();
    }

}

class Shengchan extends Thread{
    Canting canting;
    Shengchan(Canting canting){
        this.canting=canting;
    }
    @Override
    public void run(){
        try {
            for (int i=0;i<500;i++){
                System.out.println("生产者生产了第"+i+"份食物");
                canting.push();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Xiaofei extends Thread{
    Canting canting;
    Xiaofei(Canting canting){
        this.canting=canting;
    }

    @Override
    public void run(){
        try {
            for (int i=0;i<500;i++){
                System.out.println("消费者消费了第"+i+"份食物");
                canting.pop();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Canting{
    boolean flag = true;

    //生产
    public synchronized void push() throws InterruptedException {
        //食物已做好，生产者等待，请用餐
        Thread.sleep(20);
        if(flag){
            //System.out.println("食物已做好，请用餐");
            this.wait();
        }
        flag=!this.flag;
        this.notifyAll();
    }

    //消费
    public synchronized void pop() throws InterruptedException {
        //餐已吃完，消费者等待，请继续制作食物
        Thread.sleep(20);
        if(!flag){
            //System.out.println("食物已吃完，请制作");
            this.wait();
        }
        flag=!this.flag;
        this.notifyAll();
    }

}

