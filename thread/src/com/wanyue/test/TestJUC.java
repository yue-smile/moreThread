package com.wanyue.test;

import java.util.concurrent.CopyOnWriteArrayList;

//测试JUC安全类型集合
public class TestJUC {

     public static void main(String[] args) {
         CopyOnWriteArrayList<String>  list  = new CopyOnWriteArrayList<String>();
         for(int i=0;i<1000;i++){
             new Thread(()->list.add("我是wangyue"));
         }
         try {
             Thread.sleep(200);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println(list.size());
     }

}
