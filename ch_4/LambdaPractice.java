/**
 * Practice using Lambda expressions
 *
 * Book: OCA: Oracle® Certified Associate Java® SE 8 Programmer I Study Guide Exam 1Z0-808
 * Chapter 4 - Methods and Encapsulation
 *
 * Author: David Ogor
 * Date: 08-01-2015
 */
package ch_4;
import java.util.*;

class Animal {
	private String species;
	private boolean canHop;
	private boolean canSwim;
	
	public Animal(String speciesName, boolean hopper, boolean swimmer) {
		species = speciesName;
		canHop = hopper;
		canSwim = swimmer;
	}
	public boolean canHop() {
		return canHop;
	}
	
	public boolean canSwim() {
		return canSwim;
	}
	
	public String toString() {
		return species;
	}
}

interface CheckTrait {
	boolean test(Animal a);
}


class CheckIfHopper implements CheckTrait {
	public boolean test(Animal a) {
		return a.canHop();  
	}
}

public class LambdaPractice {
	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<Animal>(); // list of animals 
		animals.add(new Animal("fish", false, true)); 
		animals.add(new Animal("kangaroo", true, false)); 
		animals.add(new Animal("rabbit", true, false)); 
		animals.add(new Animal("turtle", false, true)); 
		print(animals, new CheckIfHopper());      // pass class that does check 
		print(animals, a->a.canSwim());
	}

	private static void print(List<Animal> animals, CheckTrait checker) {
		for (Animal animal : animals) {
			if (checker.test(animal)) // the general check 
			System.out.print(animal + " "); 
		} 
		System.out.println(); 
	}
}