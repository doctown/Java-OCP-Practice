class Fork {
  public static void main(String[] args) {
	  System.out.println(args.length);
	if(args.length == 2 || args[0].equals("test")) {
		System.out.println("test case");
	} else {
		System.out.println("production " + args[0]);    }
	}
  }
 