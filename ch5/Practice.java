import java.util.*;

public class Practice {

	public static void main(String[] argv) {
		
		int[] b = heapTest();
		
		stringBuilderTest();
		arraylist();
		for (int i : b) {
			System.out.println(i);
		}
	}		
	
	
	
	/*
	 * Test to see an object created in a function is permanent.
	*/
	public static int[] heapTest() {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		return a;
	}
	
	public static void stringBuilderTest() {
		int x = 0;
		//if (x = 0) { //a boolean expression must be there not a int
		if (x == 0) {
			String n = "weird";
			StringBuilder b = new StringBuilder(2);
			b.append("test");
			System.out.println(b);
			System.out.printf("Interesting: %s\n", n.toString());
		}
		
	}
	
	public static void arraylist() {
		List<String> c = new ArrayList<String>();
		System.out.println(c);
		
	}
	public static void instanceofTest() {
			Car c = new Car();
			Honda h = new Honda();
			//System.out.println("Honda is a Car -> " + h instanceof Car); // Error: incompatible types: String cannot be converted to Car
			System.out.println("Honda is a Car -> " + (h instanceof Car));
			System.out.println("Honda is a Honda -> " + (h instanceof Honda));
			System.out.println("Car is a Honda -> " + (c instanceof Honda));
		
	}
}

class Car {}

class Honda extends Car {}