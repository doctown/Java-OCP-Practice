package packageb;
import packagea.*;

public class ClassB {
	public static void main(String ... args) {
			
			
	}
	
	
	public static void testClass() {
		int b, c, d = c = b = 0;
		System.out.println("" + b + c + d);
		System.out.println("ClassB");
		ClassA a = new ClassA();
		ClassA.main(new String[] {"e","\""});
		a = null;

		int x = 5;
		int y = x = 3;
		
		if (3.1 <= y)
			System.out.println(y);
	}

	public static void garbageCollectionTest() {
			//System.gc();
			//Runtime rc = new Runtime();
			//rc.gc();
			System.out.println("Ending ClassB.");	
			
	}
}