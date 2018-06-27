package ConCurrency.documentGuide;
/**
 * @TODO
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html
 * 
 * 
 * @author Thomas
 *
 */
public class synchronizedMethod {
	public static void main(String[] args) {
		int c = 0;
		
		Thread t1 = new Thread();
		t1.run();
		
		increment(c);
		decrement(c);
		value(c);
	}

	private static void value(int c) {
		System.out.println(c);
	}

	private static void decrement(int c) {
		c++;
	}

	private static void increment(int c) {
		c--;
	}
}
