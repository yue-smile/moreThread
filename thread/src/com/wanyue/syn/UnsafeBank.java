package com.wanyue.syn;

public class UnsafeBank  {
    public static void main(String[] args) {

        Account account = new Account(12010,"结婚基金");
        Thread thread1 = new Thread(new GetMoney(account,100,"老婆"));
        Thread thread2 = new Thread(new GetMoney(account,50,"我"));
        thread2.start();
        thread1.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.name + account.money);

    }
}

class Account{
    int money;
    String name;
    public Account(int money,String name){
        this.money=money;
        this.name=name;
    }
}

class GetMoney implements Runnable{
    Account account;//从哪个账户取
    int money ;//取多少钱
    String name ;//取款人姓名
    public GetMoney(Account account,int money,String name){
        this.account = account;
        this.money = money;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (account){// synchronized 可以声明同步方法或者同步代码块，锁方法时默认锁的是this，锁代码块时指定被锁的对象
            while(account.money >= money){
                account.money = account.money -money;
                System.out.println(account.money);
            }
        }
    }
}