/*
 * Practice using constructors
 *
 * Book: OCA: Oracle® Certified Associate Java® SE 8 Programmer I Study Guide Exam 1Z0-808
 * Chapter 5 - Class Design
 *
 * Author: David Ogor
 * Date: 08-04-2015
 */
 package ch_5;
 
 public class Animal {
 
 }
 
 class Bird extends Animal {
	Bird() {
		this(7);
		System.out.println("Bird()");
	}
	
	Bird() {
		this().
		
	}
 }