package ConCurrency.sxt;

/**
 * synchronized: 当执行这段代码时候，锁定当前对象。
 * 				一个线程执行锁定区域代码时，别的线程不会打断当前线程，进入当前代码段
 * @author Thomas
 *
 */
public class syncTest implements Runnable{
	Timer timer = new Timer();
	public static void main(String[] args) {
		syncTest st = new syncTest();
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}
	
	@Override
	public void run() {
		timer.add(Thread.currentThread().getName());
	}
}

class Timer {
	private static int num = 0;
	
	/**
	 * 注释中为另外一种写法
	 * 
	 * synchronized: 执行这段代码时，当前对象被锁定
	 * @param name
	 */
	public synchronized void add(String name){
//		synchronized(){
			num++;
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " is the current Thread, number is " + num);
//		}
	}
}