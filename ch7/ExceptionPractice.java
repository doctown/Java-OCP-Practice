/**
 * 
 * Book: OCA/OCP Java® SE 7 Programmer I & II Study Guide
 * Author: David Ogor
 * Date: 07-31-2015
 */
class A_Exception extends Exception {}
public class ExceptionPractice {
	public static void main(String[] args) {
		new ExceptionPractice().testException();
	}
	
	void tryThis() throws A_Exception {}
	
	void testException() {
		try {
			tryThis();
			assert false;
		} catch (Exception e) {
				
		}
	}
}