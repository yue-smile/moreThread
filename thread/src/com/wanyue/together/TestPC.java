package com.wanyue.together;

//生产者消费者  管程法
/*
notify 和 notifyAll
notify只唤醒一个在等待的线程
notifyAll唤醒所有在等待的线程进行竞争

永远在循环（loop）里调用 wait 和 notify，不是在 If 语句
 */

public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Cosumer(container).start();
        new Product(container).start();
    }

}

class Chicken{
}

class Product extends Thread{
    SynContainer container;
    Product(SynContainer container){
        this.container=container;
    }
    @Override
    public void run(){
        try {
            for (int i=0;i<500;i++){
                System.out.println("生产者生产了第"+i+"只鸡");
                container.push(new Chicken());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Cosumer extends Thread{
    SynContainer container;
    Cosumer(SynContainer container){
        this.container=container;
    }

    @Override
    public void run(){
        try {
            for (int i=0;i<500;i++){
                System.out.println("消费者消费了第"+i+"只鸡");
                container.pop();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SynContainer{

    Chicken[] chickens = new Chicken[10];
    int i=0;

    //生产
    public synchronized void push(Chicken chicken) throws InterruptedException {
        //仓库满了，不再生产，通知消费
        while (i==10){//永远在循环（loop）里调用 wait 和 notify，不是在 If 语句
            System.out.println("仓库满了，不再生产，通知消费");
            this.wait();
        }
        if(i<10){
            //仓库没满，放入鸡
            chickens[i] = chicken;
            i++;
        }
        this.notifyAll();
    }

    //消费
    public synchronized void pop() throws InterruptedException {
        //仓库空了，不再消费，通知生产
        while (i<=0){
            System.out.println("仓库空了，不再消费，通知生产");
            this.wait();
        }
        if(i>0){
            //仓库没空进行消费
            i--;
        }
        this.notifyAll();
    }

}

