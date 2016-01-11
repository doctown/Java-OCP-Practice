package appA;

import java.io.*;
import java.util.*;

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

class ID {
	private String name;
	private int myID;
	private String company;
	
	ID(String name, String company, int id) {
		super();
		this.name = name;
		this.company = company;
		this.myID = id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCompany() {
		return company;
	}
	
	public int getID() {
		return myID;
	}
}

class ToolBox implements Serializable {
	private transient ID owner;
	private ArrayList<Tool> tools;
	private static int idCounter;
	
	public ToolBox(String name, String company) {
		owner = new ID(name, company, ++idCounter);
		tools = new ArrayList<>();
	}
	
	public void writeObject(ObjectOutputStream os) {
		try {
			os.defaultWriteObject();
			os.writeUTF(owner.getName());
			os.writeUTF(owner.getCompany());
			os.writeInt(owner.getID());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readObject(ObjectInputStream ois) {
		try {
			ois.defaultReadObject();
			ID id = new ID(ois.readUTF(), ois.readUTF(), ois.readInt());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		String str = owner.getName() + "(#" + owner.getID() + ") works for " + owner.getCompany() + ".\n";
		str += "He has the following tools in his toolbox: \n";
		for (Tool tool : tools) {
			str += tool + "\n";
		}
		return str;
	}
}