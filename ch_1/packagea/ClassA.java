package packagea;

public class ClassA {
	ClassA name;

	{System.out.println(name);}
	public static void main(String args[]) {
		System.out.println("Class A");
	}
	
	void temp() {
		
	}
	
	protected void finalize() {
		System.out.println("Class A is being garbage colleted.");
		
	}
}