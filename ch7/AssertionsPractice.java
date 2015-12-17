/*
 * Practice using assertions
 *
 * Book: OCA/OCP Java® SE 7 Programmer I & II Study Guide
 * Chapter 7: Assertions and Java 7 Exceptions
 * Author: David Ogor
 * Date: 08-13-2015
 */
 public class AssertionsPractice {
	public static void main(String[] args) {
		new One();
		int a = 5;
	//	assert(false); //assert is a keyword - use -source 1.4 or higher
	//	assert (false) : new One(); //print toString() of Object - second expression must return a value. 
	//	assert a == 4 : print(); //error: 'void' type not allowed here
		assert a == 4 : a;
		
	}
	
	static void print() {
		System.out.println("print function");
	}
 }
 
 class One {
	//int assert = 0; // assert is an identifier. use -source 1.3
	One() {
		//System.out.println(assert); //assert is an identifier
	}
 }