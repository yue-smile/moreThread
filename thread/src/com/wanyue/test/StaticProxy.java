package com.wanyue.test;

//runnable线程开启使用了静态代理
//静态代理：真实对象和代理对象都实现同一个接口
public class StaticProxy {
    public static void main(String[] args) {
        new Thread(()->System.out.println("我爱你")).start();
        HunQing hunQing = new HunQing(new You());
        hunQing.goMarry();
    }

}

interface Marry{
    void goMarry();
}

class You implements Marry{
    @Override
    public void goMarry() {
        System.out.println("我是小明，我结婚啦");
    }
}

//代理角色
class HunQing implements Marry{
    private Marry target;

    public HunQing(Marry target){
        this.target = target;
    }

    @Override
    public void goMarry() {
        System.out.println("布置现场");
        target.goMarry();
        System.out.println("收尾款");
    }
}

