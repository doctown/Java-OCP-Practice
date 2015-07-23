class BadFoodException extends Exception {}

public class MyException {
	public static void main (String[] args) {
		try {
			for (int i = 0; i < args.length; ++i) {
				
					checkFood(args[i]);
			}
		} catch (BadFoodException e) {}
		
	}
	
	public static void checkFood(String str) throws BadFoodException {
		switch(str) {
		case "apple":
			System.out.println("Good choice!");
			break;
		default:
			throw new BadFoodException();
		case "pear":
			System.out.println("Not bad.");
			break;
		}
	}
}