/*
 * Practice using regular expressions
 *
 * Book: OCA/OCP Java® SE 7 Programmer I & II Study Guide
 * Chapter 8:  String Processing, Data Formatting, Resource Bundles
 * Author: David Ogor
 * Date: 08-15-2015
 */
 package ch8;
 
import java.util.regex.*;

public class RegExpPractice {
	public static void main(String[] args) {
		//regTest(args);
		groupRegTest(args);
		//splitTest(args);
	}
	
	/**
	 * Code example copied from book.
	 */
	static public  void regTest(String[] args) {
		Pattern p = Pattern.compile(args[0]);
		Matcher m = p.matcher(args[1]);		//string to be searched
		System.out.println("\nsource: " + args[1]);
		System.out.println(" index: 01234567890123456\n"); 	// the index
		System.out.println("expression: " + m.pattern());	// the search expression
		System.out.print("match positions: "); 	//matches positions
		while (m.find()) {
			System.out.print(m.start() + " ");
		}
		System.out.println("");
	}
	
	/**
	 * Code example copied from book.
	 */
	static void groupRegTest(String[] args) {
		Pattern p = Pattern.compile(args[0]);
		Matcher m = p.matcher(args[1]);
		System.out.println("\nsource: " + args[1]);
		System.out.println(" index: 01234567890123456\n");
		System.out.println("pattern: " + m.pattern());
		while(m.find()) {
			System.out.println(m.start() + " " + m.group());
			//System.out.println(m.end() + " " + m.group());
		}
		System.out.println("");
	}
	
	/*
	 *  Code example copied from the book.
	 */
	 static void splitTest(String[] args) {
		String[] tokens = args[1].split(args[0]);    System.out.println("count " + tokens.length);    for(String s : tokens)
			System.out.println(">" + s + "<");
	}
}