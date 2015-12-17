public class PracticeCh2 {
	public static void main(String ... arg) {
		testLoop();
	}
	
	public static void testPrimitives() {
		//String str = false;
		//String str = 3;
		long xa = 2;
		int xb = 5 * (int) xa;
		byte b1 = 40;
		byte b2 = 50;
		byte b3 = (byte) (b1 + b2);
		//int x2 = 10.0; //won't compile because a float cannot be implicitly casted to an int
		/* won't compile
		do {
			int y3 = 4;
		} while (y3 != 0); */
	}
			
	public static void testLoop() {
		for(int i=0; i<10 ; ) { 
			i = i++; 
			System.out.println(i); 
		}	
	}
	
}