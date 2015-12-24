package appA;

import java.io.*;

/** 
 * Practice using serialization with Java classes.
 *
 * Book: OCA/OCP Java® SE 7 Programmer I & II Study Guide
 * Appendix A
 * Author: David O.
 * Date: 12-24-2015
 */
 public class AppendixAPractice {
	/** the name of where the serialized object will be stored */
	private static final String FILE_NAME = "appA/testSer.ser";
	
	public static void main(String[] args) {
		serialPractice();
	}
	
	/** 
	 * Test saving a class and opening it again.
	 */
	public static void serialPractice() {
		Tool tool = new Tool("hammer");
		try {
			FileOutputStream fs = new FileOutputStream(FILE_NAME);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(tool);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Original tool:" + tool);
		
		try {
			FileInputStream fs = new FileInputStream(FILE_NAME);
			ObjectInputStream ois = new ObjectInputStream(fs);
			tool = (Tool) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Retreived tool:" + tool);
	}
}

class Tool  implements Serializable {
	private String name;
	
	public Tool(String name) {
		super();
		this.name = name;
	}
	
	public Tool() {
		this("unknown");
	}
	
	public String getTool() {
		return name;
	}
	
	public String toString() {
		return "I am a " + name;
	}
}