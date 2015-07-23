package packageb;
import packagea.*;

public class ClassB {
	public static void main(String ... args) {
			int b, c, d = c = b = 0;
			System.out.println("" + b + c + d);
			System.out.println("ClassB");
			ClassA a = new ClassA();
			ClassA.main(new String[] {"e","\""});
		}
}