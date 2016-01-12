/**
 * OCA - Practice using breaks/continues with labels
 */
public class Ex6_2 {
	public static void main(String[] args) {
		int age = 5;
	
		outer:
		while (age < 21) {
			++age;
			if (age == 16) {
				System.out.println("You can get your driver's license!");
				continue outer;
			}
			System.out.println("Another year.");
		}
	}

}