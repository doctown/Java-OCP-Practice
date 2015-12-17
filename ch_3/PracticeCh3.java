/**
 * Practice of concepts learned in Chapter 3 on ArrayList and Strings
 * 
 * Book: OCA: Oracle® Certified Associate Java® SE 8 Programmer I Study Guide Exam 1Z0-808
 * Author: David Ogor
 * Date: 07-28-2015
 */
import java.util.ArrayList;
import java.util.List;
import java.time.*;

public class PracticeCh3 {
	public static void main(String[] args) {
		arraylistPractice();
		datePractice();
		examPractice();
	}
	
	/**
	 * Test what can be added to an ArrayList.
	 */
	 public static void arraylistPractice() {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("1");
		list.add("String");
		list.add(2, "Two");
		System.out.println(list);
	 }
	 
	 /**
	  * Code from textbook.
	  */
	  public static void listPractice() {
		/*Convert a list to an Array
		Object[] objectArray = list.toArray();
		System.out.println(objectArray.length);
		String[] stringArray = list.toArray(new String[0]);
		System.out.println(stringArray.length);
		List<String> list = new ArrayList<>(); 
		list.add("hawk");
		list.add("robin"); 
		Object[] objectArray = list.toArray(); 
		System.out.println(objectArray.length);     // 2
		String[] stringArray = list.toArray(new String[0]); 
		System.out.println(stringArray.length);     // 2
		*/
	 }	
	 
	 /**
	  * Practice test questions
	  */
	  public static void examPractice() {
		 //wrong type String s = 3;
		 //wrong type String s = false;
		 String s = "three";
		  StringBuilder sb = new StringBuilder(s);
		  System.out.println(s.equals(sb));
		  System.out.println(sb.equals(s));
		  System.out.println("s = " + s);
	  }
	 
	 /**
	  * Practice using date class.
	  */
	  public static void datePractice() {
		  System.out.println(LocalDate.now());
		  System.out.println(LocalTime.now());
		  System.out.println(LocalDateTime.now());
		  
	  }
}