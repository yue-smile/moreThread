package com.wanyue.test;


/*
函数式编程

函数式接口：
    任何接口如果只包含一个抽象方法，那么它就是一个函数式接口

    对于函数式接口，我们可以通过lambda表达式来创建该接口的对象
 */

public class LambdaDemo {
    //静态内部类
    static class LikeLambdaImpl2 implements Lambdable{
        public void lamda(){
            System.out.println("22222222我是静态内部类");
        };
    }

    public static void main(String[] args) {
        Lambdable lambdable = new LikeLambdaImpl();
        lambdable.lamda();

        Lambdable lambdable2 = new LikeLambdaImpl2();
        lambdable2.lamda();


        //局部内部类
        class LikeLambdaImpl3 implements Lambdable{
            public void lamda(){
                System.out.println("33333333我是局部内部类");
            };
        }
        Lambdable lambdable3 = new LikeLambdaImpl3();
        lambdable3.lamda();

        //匿名内部类 必须借助接口或者父类
        Lambdable lambdable4 = new Lambdable() {
            @Override
            public void lamda() {
                System.out.println("44444444我是匿名内部类");
            }
        };
        lambdable4.lamda();

        //使用lambda表达式
        Lambdable lambdable5 = ()->{
            System.out.println("55555555我是lambda表达式");
        };
        lambdable5.lamda();
    }
}


//1 定义一个函数式接口
interface Lambdable{
    void lamda();
}

//2 实现类
class LikeLambdaImpl implements Lambdable{
    public void lamda(){
        System.out.println("11111111我是外部实现类");
    };
}



