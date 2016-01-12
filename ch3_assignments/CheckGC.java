import java.util.Date;
public class CheckGC {
	public static void main(String [] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println("Total JVM memory: " + rt.totalMemory());
		System.out.println("Before Memory = \n\n" + rt.freeMemory());
		Date d = null;
		for(int i = 0;i<10000;i++) {
			d = new Date();
			d = null; 
			if (i % 100 == 0) {
				System.out.printf("Round: %d\n", i);
				System.out.println("After Memory    = "  + rt.freeMemory());
				rt.gc();   // an alternate to System.gc() 	
				System.out.println("After GC Memory = " + rt.freeMemory()); 
			}
		}
	} 
;}