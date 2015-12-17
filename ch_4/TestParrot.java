/**
 * Practice accessing protected methods.
 *
 * Book: OCA: Oracle® Certified Associate Java® SE 8 Programmer I Study Guide Exam 1Z0-808
 * Chapter 4 - Methods and Encapsulation
 *
 * Author: David Ogor
 * Date: 08-01-2015
 */
 package oca.ch_4;
 
 public class TestParrot {
	public static void main(String[] args) {
		Parrot p = new Parrot();
		//p.noise(); // error: noise() has protected access in Bird
		p.callParentNoise();
	}
 }