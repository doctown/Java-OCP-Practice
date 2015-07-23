public class numbers{
	public static void main(String[] args) {
		//int oct = 09; //won't compile because 09 is not an octal
		int oct = 10;
		//float fl = 234.4323; //won't compile because default is long
		float fl = 234.4323F;
		byte a = 3;
		//a = byte a + 3; // needs explicit cast
		//a = byte (a + 3); () needed for cast
		a = (byte) (a + 3);
		
		char c = \u0090;
		System.out.println(c);
	}
}