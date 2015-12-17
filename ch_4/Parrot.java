/**
 * Practice accessing protected methods.
 *
 * Book: OCA: Oracle® Certified Associate Java® SE 8 Programmer I Study Guide Exam 1Z0-808
 * Author: David Ogor
 * Date: 08-01-2015
 */
package oca.ch_4;
import oca.ch_3.Bird;

public class Parrot extends Bird {
	public Parrot() {
		sound = "Squawk";
	}
	
	public void callParentNoise() {
		noise();
		new Parrot().noise();
		Bird b = new Parrot();
		//b.noise(); // error: noise() has protected access in Bird
	}
}