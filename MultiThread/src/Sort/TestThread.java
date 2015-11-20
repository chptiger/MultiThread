/* (程序头部注释开始)
* 程序的版权和版本声明部分
* Copyright (c) 2011, 烟台大学计算机学院学生 
* All rights reserved.
* 文件名称：   《多线程的练习—排序问题——Java第十四周》                           
* 作    者：       刘江波                       
* 完成日期：    2012     年   12    月    1    日
* 版 本 号：    v2.1    

* 对任务及求解方法的描述部分 
* 问题描述： 

1.请编写多线程程序。先封装一类对象RandomNumber，功能是先产生一个大于10的随机整数n，再产生n个随机数并存放于数组中。然后封装两个线程Thread1（要求是Thread的子类）和Thread2（要求实现Runnable接口）并发地对所生成的随机数进行排序，其中Thread1要求采用冒泡排序法进行排序，并输出排序结果。Thread2要求采用快速排序法进行排序，并输出排序结果。最后编写主线程TestThread，加入上述两个线程实现程序的并发，比较这两个线程排序的结果。（必做题）
* 程序头部的注释结束
*/
package Sort;

public class TestThread {  
	  
    /* 
     *请编写多线程程序。先封装一类对象RandomNumber，功能是先产生一个大于10的随机整数n， 
     *再产生n个随机数并存放于数组中。然后封装两个线程Thread1（要求是Thread的子类） 
     *和Thread2（要求实现Runnable接口）并发地对所生成的随机数进行排序，其中Thread1要求采用冒泡排序法进行排序， 
     *并输出排序结果。Thread2要求采用快速排序法进行排序，并输出排序结果。最后编写主线程TestThread， 
     *加入上述两个线程实现程序的并发，比较这两个线程排序的结果。（必做题） 
    */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        RandomNumber r = new RandomNumber();  
        Thread1 t1 = new Thread1(r);  
        Thread2 t2 = new Thread2(r);  
          
//      Thread thread1 = new Thread();  
//      Thread thread2 = new Thread(t2);  
//        
//      thread1.start();  
//      thread2.start();  
        t1.run();  
        t2.run();  
    }  
  
}  
