package com.wanyue.create;

import java.util.concurrent.*;

//线程创建方式三 实现Callable接口  可以定义返回值 可以抛出异常
public class Thread03 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName()+"我是通过callable创建的线程 啦啦啦";
    }

    public static void main(String[] args) {
        Thread03 thread031 = new Thread03();
        Thread03 thread032 = new Thread03();
        Thread03 thread033 = new Thread03();

        //step1 创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //step2 提交执行
        Future<String> result1 = executorService.submit(thread031);
        Future<String> result2 = executorService.submit(thread032);
        Future<String> result3 = executorService.submit(thread033);
        //step3 获取结果
        try {
            System.out.println(result1.get());
            System.out.println(result2.get());
            System.out.println(result3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //step4 关闭服务
        executorService.shutdown();



    }

}
