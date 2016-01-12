import java.lang.*;

/**
 * Catch an exception
 */
public class Propagate {
	public static void main(String[] args) {
		String str = "This is a test";
		try {
			System.out.println(reverse(str));
			System.out.println("o" + reverse(""));
			System.out.println("Last part of try.");
		} catch (Exception e) {
			System.out.println("inside Exception catch");
		} catch (IllegalArgumentException e) { 
			System.out.println("Inside IllegalArgumentException catch");
		} finally {
			System.out.println("Final block running");
		}
		
	}
	
	/**
	 * Reverse the content of a string.
	 */
	 public static String reverse(String str) {
		if (str.length() == 0) {
			throw new IllegalArgumentException();
		}
		String rev = "";
		for (int i = str.length() - 1, k = 0; i >= 0; --i, ++k) {
			rev += str.charAt(i);
		}
		return rev;
	 }
}