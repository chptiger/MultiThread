package Sort;

public class Thread1 extends Thread {  
    
    private int Thread1[];  
    Thread1(RandomNumber rn)  
    {  
        Thread1 = new int[rn.num.length];   
        Thread1 = rn.num;  
    }  
    public void run()  
    {  
        for(int i=0; i<Thread1.length; i++)  
        {  
            for(int j=0; j<Thread1.length-i-1; j++)  
            {  
                if(Thread1[j] > Thread1[j+1])  
                {  
                    int mid = Thread1[j];  
                    Thread1[j] = Thread1[j+1];  
                    Thread1[j+1] = mid;  
                }  
            }  
        }  
        for(int i=0; i<Thread1.length; i++)  
        {  
            System.out.println(Thread1[i]);  
        }  
        System.out.println("Thread1打印完成。");  
    }  
} 