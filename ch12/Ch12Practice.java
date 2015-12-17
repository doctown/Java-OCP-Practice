package ch12;

public class Ch12Practice {
	private int num;
	
	Ch12Practice() {
	}
	
	void show() {
		System.out.println("num = %d", num);
	}
	public static void main(String[] args) {
		innerClassTest();
		Tree tree = new Tree();
		Leaf leaf = new Tree.Leaf();
		leaf.show();
	}

	/**
	 * Attempt to access the inner class before an instance of the outer class has occurred.
	 * Then try after the outer class has been instantiated.
	 */
	public static void innerClassTest() {
		InnerClass innie = new Ch12Practice.InnerClass();
		innie.show();
		Ch12Practice practice = new Ch12Practice();
		practice.show();
		practice.incrementNum();
		practice.InnerClass().incrementNum();
		practice.show();
		
	}
	class InnerClass {
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