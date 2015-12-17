package ch13;
import java.lang.Runnable;

public class Ch13Practice {
	public static void main(String[] args) {
		System.out.println("This class is working!");
		testThread();
		testThread2();
	}
	
	public static void testThread() {
		Thread thr = new Thread(new MyRunnable());
		Thread thr2 = new Thread(new MyRunnable());
		Thread thr3 = new Thread(new MyRunnable());
		thr.start();
		thr2.start();
		thr3.start();
	}
	
	/**
	 * Test the sleep method in an extended thread class
	 */
	public static void testThread2() {
		MyThread thd = new MyThread();
		thd.start();
	}
}

class MyRunnable implements Runnable {
	private static int x;
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("Important job running in MyRunnable by %s and x is %d\n", Thread.currentThread().getName(), x = x + 2);		
		}
	}
}

class MyThread extends Thread {
	public void run() {
		try {
		for (int i = 0; i < 15; i++) {
			System.out.println("I am in thread class");
			sleep(1000);
		}
		} catch (InterruptedException e) {
			
		}
	}
}