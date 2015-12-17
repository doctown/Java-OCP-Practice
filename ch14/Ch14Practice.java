import java.util.concurrent.*;

public class Ch14Practice {
	public static void main(String[] args) {
		sharingVariable();
	}
	
	/**
	 * Demonstrates problem with incrementing a variable
	 */
	public static void sharingVariable() {
		Game g = new Game();
		Thread thd1 = new Thread(g);
		Thread thd2 = new Thread(g);
		
		thd1.start();
		thd2.start();
		try {
			thd1.join();
			thd2.join();
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("Final count is " + g.getCount());
		System.out.println("Final synchronized count is " + g.getSynchCount());
		System.out.println("Final atomic count is " + g.getAtmCount());
	}
	
}

class Game implements Runnable {
	private static int count;
	private static int synchCount;
	private static AtomicInteger atmCount;
	
	public static final int LIMIT = 10000;
	
	public void increment() {
		count++;
	}
	
	public void atmIncrement() {
		atmCount.getAndIncrement();
	}
	
	public synchronized void synchIncrement() {
		count++;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getSynchCount() {
		return synchCount;
	}
	
	public int getAtomicCount() {
		return atmCount;
	}
	
	public void run() {
		for (int i = 0; i < LIMIT; i++) {
			increment();
			synchIncrement();
			atmIncrement();
		}
	}
}