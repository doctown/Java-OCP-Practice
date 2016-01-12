/**
 * Practice all the concepts learned in the chapter.
 */
package ch9;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class Ch9Practice {
	public static void main(String[] args) {
		//fileSummary();
		pathsSummary();
	}
	
	/**
	 * Create, rename, and delete files using the File object.
	 */
	public static void fileSummary() {
		char[] buffer = new char[1000];
		int bytes_read = 0;
		File dir = new File("/java/oca/ch9/dir");
		File file = new File(dir, "summary.txt");
		
		try {
			if (!dir.exists()) {
				dir.mkdir();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file);
			String text = "This is some important information.";
			fw.write(text);
			fw.flush();
			fw.close();
			
			FileReader fr = new FileReader(file);
			bytes_read = fr.read(buffer);
			for (char ch : buffer) {
				if (ch != '\0') {
					System.out.print(ch);
				}
			}
			fr.close();
			
			System.out.println();
			getAccountInfo(file);
			
			File new_file = new File("/java/oca/ch9/dir/I love tacos.txt");
			file.renameTo(new_file);
			
			//Delete old file in current directory
			File old_file = new File("I love tacos.txt");
			if (old_file.exists()) {
				old_file.delete();
			}
			
		} catch (IOException e) {
			System.out.println(e);
		}		
	}
	
	/**
	 * Prompt user for account information using Console and use BufferedWriter and reader to add it to the file.
	 */
	public static void getAccountInfo(File file) {
		char[] passwd;
		String uname;
		Console c = System.console();
		
		uname = c.readLine("Enter your username: ");
		passwd = c.readPassword("Enter your password: ");
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			bw.append(uname);
			bw.newLine();
			for (char ch : passwd) {
				bw.append(ch);
			}
		} catch (IOException e) {
			System.out.println("BufferedWriter: " + e);
		}
	}
	
	/** 
	 * Create, delete, and rename a file using the Paths object.
	 */
	 public static void pathsSummary() {
		 Path file = Paths.get("another file.txt");
		 Path dir = Paths.get("/java/oca/ch9/path/dir/");
		 Path target = Paths.get("copy of another file");
		 try {
			Files.createDirectories(dir);
			Path resolved = dir.resolve(file);
			Files.createFile(resolved);
			Files.copy(file, target);
		 } catch (IOException e) {
			System.out.println("Paths: " + e);
		 }
	 }
}