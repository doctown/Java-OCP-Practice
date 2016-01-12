/**
 * Practice using inner classes.
 *
 * Book: OCA/OCP Java® SE 7 Programmer I & II Study Guide
 * Chapter 12: Inner Classes
 * Author: David O.
 * Date: 11-15-2015
 */
package ch12;

public class Ch12Practice {
	private int num;
	
	Ch12Practice() {
	}

	public static void main(String[] args) {
		new Ch12Practice().innerClassTest();
		Tree tree = new Tree();
		Tree.Leaf leaf = new Tree.Leaf();
		leaf.show();
		circleTest();
	}
	
	public static void circleTest() {
		System.out.println("NON-STATIC INNER CIRCLE");
		Circle c = new Circle(0, 0, 4);
		System.out.println(c);
	}
	
	void show() {
		System.out.printf("num = %d", num);
	}

	/**
	 * Attempt to access the inner class before an instance of the outer class has occurred.
	 * Then try after the outer class has been instantiated.
	 */
	public void innerClassTest() {
		/* Fails -> error: non-static variable this cannot be referenced from a static context when innerClassTest is static */
		InnerClass innie = new InnerClass(); 
		Ch12Practice practice = new Ch12Practice();
		practice.show();
		innie.incrementNum();
		practice.show();
		
	}
	
	class InnerClass {
		public InnerClass() {}
		public void incrementNum() {
			num++;
		}
	}
}

class Tree {
	static class Leaf {
		public void show() {
			System.out.println("I am a leaf on a tree.");
		}
	}
}

/**
 * Non-static inner class. A circle object.
 */
class Circle {
	class Point {
		private int xCoord;
		int yCoord;
		Point(int x, int y) {
			xCoord = x;
			yCoord = y;
		}
	}
	Point center;
	int radius;
	
	Circle(int x, int y, int r) {
		center = new Point(x, y);
		radius = r;
	}
	
	public String toString() {
		return "The center is (" + center.xCoord + "," + center.yCoord + ") and the radius is " + radius;
	}
}