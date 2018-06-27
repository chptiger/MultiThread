/*package ConCurrency.sxt;

*//**
 * 线程： 一个程序里面不同的执行路径。 工人
 * 进程： 一个class文件或者一个exe文件，是一个静态概念. 生产车间
 * 
 * http://www.ruanyifeng.com/blog/2013/04/processes_and_threads.html
 * 
 * 进程  就好比工厂的车间，它代表CPU所能处理的单个任务。任一时刻，CPU总是运行一个进程，其他进程处于非运行状态。
 * 线程  就好比车间里的工人。一个进程可以包括多个线程
 * @author Thomas
 *
 *//*
public class ProducerConsumer {
	 public static void main(String[] args) {
		SyncStack ss = new SyncStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		new Thread(p).start();
		new Thread(c).start();
	}
}

class Bread{
	int id;
	
	Bread(int id){
		this.id = id;
	}
	
	public String toString(){
		return "Bread " + id;
	}
}

class SyncStack{
	int index = 0;
	Bread[] arrBread = new Bread[6];
	
	public synchronized void push(Bread br){
//		attention: not use if. If notify by consumer
		while(index == arrBread.length){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		arrBread[index] = br;
		index++;
		this.notifyAll();
		System.out.println("Producer: " + br);
	}
	
	public synchronized Bread pop(){
		while(0 == index){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		index--;
		this.notifyAll();
		return arrBread[index];
	}
}

class Producer implements Runnable{
	SyncStack ss = null;
	Producer(SyncStack ss){
		this.ss = ss;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 20; i++){
			Bread br = new Bread(i);
			ss.push(br);
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}

class Consumer implements Runnable{
	SyncStack ss = null;
	Consumer(SyncStack ss){
		this.ss = ss;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 20; i++){
			Bread br = ss.pop();
			System.out.println("Consumer: " + br);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}*/