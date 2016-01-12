public class Practice {
	public static void main(String[] args) {
		caseTest();
		switchTest();
		continueTest();
	}

	public static void continueTest() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Inside loop");
			continue;
		}
	}
	public static void switchTest() {
		char x = '4';
		switch (x) {
			case '1': 
				System.out.println("One");
				break;
			case 52:
				System.out.print("One + ");
				System.out.print("One + ");
				System.out.print("One + ");
				System.out.print("One = ");
				System.out.println("Four");
		}	
	}
	/**
	 * Test different values for case
	 */
	public static void caseTest() {
		final int a = 1; 
		final int b; 
		b = 2; 
		int x = 0; 
		switch (x) {
			case a:     // ok
			//case b:     // compiler error //error: constant expression required
		}
	}
}