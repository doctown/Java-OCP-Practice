/*
 * Create and test a resource bundle.
 *
 * TODO: Did not work. Could not find resource bundle
 *
 * Book: OCA/OCP Java® SE 7 Programmer I & II Study Guide
 * Chapter 8:  String Processing, Data Formatting, Resource Bundles
 * Date: 08-19-2015
 */
 package ch8;
 
 import java.util.Locale;
 import java.util.ResourceBundle;
 
 public class ResourceBundlePractice {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage error: ResourceBundlePractice [locale] ");
		} else {
			resourceBundleTest(args);
		}
	}
	
	/** 
	 * Create a resource bundle.
	 */
	public static void resourceBundleTest(String[] args) {
		//First create locale
		//Locale locale = new Locale(args[0]);
		Locale locale = new Locale("en", "CA");
		//Second
		ResourceBundle rb = ResourceBundle.getBundle("StatsBundle", locale);
		
		System.out.println(rb.getString("hello"));
	}
 }