/**
 * A general class of a bird.
 * Practice of concepts learned in chapter 4: Methods and Encapsulation
 *
 * Book: OCA: Oracle® Certified Associate Java® SE 8 Programmer I Study Guide Exam 1Z0-808
 * Author: David Ogor
 * Date: 08-01-2015
 */
package oca.ch_3;
public class Bird {
	/** a sound an animal makes */
	protected String sound;
	
	/**
	 * Prints the sound.
	 */
	 protected void noise() {
		if (sound != null) {
			System.out.println(sound);
		} else {
			System.out.println("no sound set");
		}
	 }
}