/**
 * Practice of concepts learned in chapter 4: Methods and Encapsulation
 *
 * Book: OCA: Oracle® Certified Associate Java® SE 8 Programmer I Study Guide Exam 1Z0-808
 * Author: David Ogor
 * Date: 07-31-2015
 */
 package ch_4;
 
 public class PracticeCh4 {
	private int num = 5;

	static
	{
		num += 4;
	}
	public static void main(String args[]) {
		System.out.println(returnTypePractice());
		System.out.println(num);
		new PracticeCh4();
		System.out.println(num);
	}
 
	/**
	 * Try to return a implicitly converted primitive.
	 */
	 public static int returnTypePractice() {
		byte b = 1;
		return b;
	 }
}