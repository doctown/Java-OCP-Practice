/*
 * Create and test a resource bundle.
 *
 * TODO: Did not work. Could not find resource bundle
 *
 * Book: OCA/OCP Java® SE 7 Programmer I & II Study Guide
 * Chapter 8:  String Processing, Data Formatting, Resource Bundles
 * Date: 08-19-2015
 */
package ch8_strings_locale;
 
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Arrays;
import java.util.*;
 
class AvailableLocales {
	public void showLocales() {
		System.out.println("The default locale is: " + Locale.getDefault());
		Locale[] locales = Locale.getAvailableLocales();
		System.out.printf("There are %d locales\n", locales.length);
		Arrays.sort(locales, new Comparator<Locale>() {
			public int compare(Locale one, Locale another) {
				return one.toString().compareTo(another.toString());
			}
		});
		
		for (Locale loc : locales) {
			System.out.printf("%15s%s which stands for %s %n","Locale code: ", loc, loc.getDisplayName());
		}
	}
}
 
public class ResourceBundlePractice {
	public static void main(String[] args) {
		if (args.length == 0) {
			new AvailableLocales().showLocales();
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