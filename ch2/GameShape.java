public class GameShape {
	static int num_stat = 0;
	int num_inst = 0;
	private String str;
	
	{ 
		System.out.println("1st init block");
	}
		
	public GameShape(int i) {
		str = "" + i;
		System.out.println("Inside GameShape constructor" + str);
	}

	private GameShape() {
		this(4);
		++num_stat;
		++num_inst;
		System.out.printf("static int: %d\n", num_stat);
		System.out.printf("inst int: %d\n", num_inst);
	}
	public void doShape() {
	    System.out.printf("doShape: Inside GameShape class.");
		
	}
	
	{ 
				System.out.println("2nd init block");
			}
	GameShape doGame() {
		{
			
		}
		return null;
	}
	
	static { 
				System.out.println("1st static init block");
	}
			
	public static int getNum() {
		return num_stat;
	}
	
}