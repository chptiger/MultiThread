package ConCurrency.practice;

/**
 * 
 * http://coolxing.iteye.com/blog/1236696
 * 
 * Q1, while (state != xx)是否可以换成if(state != xx), 为什么?
 *  考虑以下场景，即abc顺序步骤。
 * 	a、1处于synchronized，2处于waiting，3抢到锁后notifyAll结束5轮打印，剩下1和2竞争锁；
	b、2抢到锁继续执行，执行后state变为3并notifyAll；
	c、2在notifyAll后1还没来得及抢到锁，2就执行到了synchronized，并又再次获取了锁，由于state=3，2就waiting，这个时候处于synchronized的1抢到锁，由于state=3，1也waiting。
	c也可以换为：1抢到了锁，由于state=3，1就waiting，这个时候处于synchronized的2抢到锁，由于state=3，2也waiting。造成死锁。
 *
 * 为什么 while 不会造成死锁？ 都是 state ！= curentState 时候，wait.
 * 如果wait()a时候发生Exception，使用while会继续检查， 此时使用if只检查一次，跳过了检查。教科书中都是使用 while。！！！！！
 * 
 * @TODO
 * Q2,为什么使用 final关键字？ 不使用该结果，不影响结果
 * @author Thomas
 *
 */
public class NumberPrintConcurrency {
	
	private static int n = 1;
	private static int state = 1;
	
	public static void main(String[] args) {
		final NumberPrintConcurrency pc = new NumberPrintConcurrency();
		
		new Thread(new Runnable() {
			public void run() {
				printNumberProcess1(pc);
			}
		}, "线程1").start();
		
		new Thread(new Runnable() {
			public void run() {
				printNumberProcess2(pc);
			}
		}, "线程2").start();
		
		new Thread(new Runnable() {
			public void run() {
				printNumberProcess3(pc);
			}
		}, "线程3").start();
	}
	
	public static void printNumberProcess1(NumberPrintConcurrency pc) {
		for(int i = 0; i < 6; i++){
			synchronized(pc){
				while(state!=1){
					try {
						pc.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int j = 0; j < 5; j++){
					System.out.println(Thread.currentThread().getName() + ": " + n++);
				}
				
				System.out.println();
				
				state = 2;
				pc.notifyAll(); 
			}
		}
	}
	
	public static void printNumberProcess2(NumberPrintConcurrency pc) {
		for(int i = 0; i < 6; i++){
			synchronized(pc){
				while(state!=2){
					try {
						pc.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int j = 0; j < 5; j++){
					System.out.println(Thread.currentThread().getName() + ": " + n++);
				}
				
				System.out.println();
				
				state = 3;
				pc.notifyAll(); 
			}
		}
		
	}
	
	public static void printNumberProcess3(NumberPrintConcurrency pc) {
		for(int i = 0; i < 6; i++){
			synchronized(pc){
				while(state!=3){
					try {
						pc.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int j = 0; j < 5; j++){
					System.out.println(Thread.currentThread().getName() + ": " + n++);
				}
				
				System.out.println();
				
				state = 1;
				pc.notifyAll(); 
			}
		}
	}
}
