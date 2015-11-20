package Sort;

public class RandomNumber {  
    
    /* 
     * 先封装一类对象RandomNumber，功能是先产生一个大于10的随机整数n，再产生n个随机数并存放于数组中。 
     */  
    private int i ;  
    public int num[];  
      
    RandomNumber(){  
        i = (int)(Math.random()*100)+11;  
        num = new int[i];  
          
        for(int j=0; j<i; j++)  
        {  
            num[j] = (int)(Math.random()*100);  
        }  
    }  
}  
