package Sort;

import java.util.Arrays;

public class Thread2 implements Runnable {  
    
    private int Thread2[];  
    Thread2(RandomNumber rn)  
    {  
        Thread2 = new int[rn.num.length];   
        Thread2 = rn.num;  
    }  
  
    public void run() {  
        // TODO Auto-generated method stub  
        Arrays.sort(Thread2, 0, Thread2.length);  
        for(int i=0; i<Thread2.length; i++)  
        {  
            System.out.println(Thread2[i]);  
        }  
        System.out.println("Thread2打印完成。");  
    }  
      
}  
