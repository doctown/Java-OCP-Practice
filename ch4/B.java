class A { } 
class B extends A {
	public static void main (String [] args) {
		A myA = new B();
		m2(myA);
		B[] b = new B[3];
		if (b instanceof Object) {
			System.out.println("b is instanceof B");			
		System.out.println(5 + 5 + "3hth" + 9);
		}
		
		int x = 5;
		x *= 10 + 10;
		System.out.println("x = " + x);
		
	}
  
	public static void m2(A a) {
		if (a instanceof B)
			((B)a).doBstuff();     // downcasting an A reference to a B reference
	}	
  
	public static void doBstuff() {
		System.out.println("'a' refers to a B");
	}
}