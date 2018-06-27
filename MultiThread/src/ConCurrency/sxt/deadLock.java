package ConCurrency.sxt;

/**
 * 死锁：一个线程执行完成需要两个对象。
 * 		两个线程分别锁住一个对象，等待另外一个线程释放需要的另一个对象完成操作，一直互相等待出现死锁现象。
 * @author Thomas
 *
 */
public class deadLock implements Runnable{
	public int flag = 1;
//	static is very important, could not created by new object.
	static Object o1 = new Object(), o2 = new Object();
	
	public static void main(String[] args) {
		deadLock d1 = new deadLock();
		deadLock d2 = new deadLock();
		d1.flag = 1;
		d2.flag = 0;
		new Thread(d1).start();
		new Thread(d2).start();
	}

	public void run() {
		if(flag == 1){
			System.out.println(flag);
			synchronized (o1) {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(o2){
					System.out.println("flag == 1");
				}
			}
		}
		
		if(flag == 0){
			System.out.println(flag);
			synchronized (o2) {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(o1){
					System.out.println("flag == 0");
				}
			}
		}
	}
}
