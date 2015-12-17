/*
 * Test using the try with resources feature.
 *
 * Book: OCA/OCP Java® SE 7 Programmer I & II Study Guide
 * Chapter 7: Assertions and Java 7 Exceptions
 * Author: David Ogor
 * Date: 08-13-2015
 */
class One implements AutoCloseable {
	public void close() {
		System.out.println("Close One");
	}
}

class Two implements AutoCloseable {
	public void close() {
		System.out.println("Close Two");
	}
}

public class TryPractice {
	/**
	 * Test when a try with resources automatically calls various blocks
	 */
	public static void main(String[] args) {
		try (One o = new One(); Two t = new Two()) {
			System.out.println("First try without catch or finally.");
		}

		try (One o = new One(); Two t = new Two()) {
			System.out.println("");
			System.out.println("Second try with catch and without finally.");
			throw new Exception();
		} catch (Exception e) {
			System.out.println("Catch called");
		}


		try (One o = new One(); Two t = new Two()) {
			System.out.println("");
			System.out.println("Third try with finally.");
			o.close();
		} finally {
			System.out.println("Finally");
			//o.close(); o out of scope
		}
	}
}