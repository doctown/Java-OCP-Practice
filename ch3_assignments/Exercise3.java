public class Exercise3 {
	
	public static void main(String[] args) {
		short x = (short) 1200032.90;
		byte b = 3;
		
		System.out.println("short: " + x);
		System.out.println("byte: " + b);
		
		b += 3;
		System.out.println("byte: " + b);
		
		b = (byte) (b + 7);
		System.out.println("byte: " + b);
	}
}
		