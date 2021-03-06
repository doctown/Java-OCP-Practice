package ch14;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;

/*
 * Book: OCA/OCP Java® SE 7 Programmer I & II Study Guide
 * Chapter 14
 * Author: David O.
 * Date: 12-17-2015
 */
public class Ch14Practice {
	public static void main(String[] args) {
		sharingVariable();
		sharingList();
	}
	
	/**
	 * Demonstrates problem with incrementing a variable without synchronization.
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
		System.out.println("Final atomic count is " + g.getAtomicCount());
	}
	
	/**
	 * Demonstrate the problem when an Collection like an arraylist is not thread safe. 
	 */
	public static void sharingList() {
		FavoriteBooks fb = new FavoriteBooks();
		Thread thd1 = new Thread(fb);
		Thread thd2 = new Thread(fb);
		
		thd1.start();
		thd2.start();
	}
}

/**
 * A class of favorite books to work with a collection.
 */
class FavoriteBooks implements Runnable {
	private List<String> books = new ArrayList<String>();
	private CopyOnWriteArrayList<String> booksCopyList = new CopyOnWriteArrayList<>();
	private Game counter = new Game();
	
	FavoriteBooks() {
		for (int i = 0; i < Game.LIMIT; i++) {
			books.add("book #" + i);
		}
		
		for (int i = 0; i < Game.LIMIT; i++) {
			booksCopyList.add("book #" + i);
		}
	}
	
	/**
	 * Remove the elements from a list.
	 */
	public void run() {
		String name = Thread.currentThread().getName();
		while (!books.isEmpty()) {
			books.remove(0);
			counter.atmIncrement();
			
		}
		System.out.printf("%d items were removed\n", counter.getAtomicCount());
		
		while (!booksCopyList.isEmpty()) {
			booksCopyList.remove(0);	
			counter.synchIncrement();
		}
		
		System.out.printf("%d items were removed\n", counter.getAtomicCount());
	}
}
/**
 * Allows a shared count to be incremented by participants.
 */
class Game implements Runnable {
	private static int count;
	private static int synchCount;
	private static AtomicInteger atmCount = new AtomicInteger();
	
	public static final int LIMIT = 10000;
	
	public void increment() {
		count++;
	}
	
	public void atmIncrement() {
		atmCount.getAndIncrement();
	}
	
	public synchronized void synchIncrement() {
		synchCount++;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getSynchCount() {
		return synchCount;
	}
	
	public int getAtomicCount() {
		return atmCount.intValue();
	}
	
	public void run() {
		for (int i = 0; i < LIMIT; i++) {
			increment();
			synchIncrement();
			atmIncrement();
		}
	}
}