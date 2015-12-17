/*
 * Practice creating, reading, and writing to files
 * 
 * Book: OCA/OCP Java® SE 7 Programmer I & II Study Guide
 * Chapter 9:  I/O and NIO 
 * Author: David O
 * Date: 08-25-2015
 */
 package ch9;
 
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

 public class FilePractice {
	public static void main(String[] args) {
		//fileTest();
		//dirTest();
		//newConsole();
		//nioTest();
		//dosTest();
		directoryStreamTest();
		//pathVisitorTest();
	}
 
 /**
  * Test creating and opening a file.
  */
  public static void fileTest() {
	char[] buf = new char[50];
	int size = 0;
	
	try {
		File file = new File("myFile.txt");
		FileWriter fw = new FileWriter(file);
		
		fw.write("I have a dream!");
		fw.flush();
		fw.close();
		
		FileReader fr = new FileReader(file);
		size = fr.read(buf);
		
		System.out.println("Size: " + size);
		for (char c : buf) {
			System.out.print(c);
		}
		System.out.println();
		fr.close();
	} catch (IOException e) {
		  System.out.println(e);
	  }
  }
  
  /**
   * Create directory
   */ 
   public static void dirTest() {
	   char[] buf = new char[50];
	   
	   File myDir = new File("mydir");
	   myDir.mkdir();
	   File file = new File(myDir, "data.txt");
	   
	   System.out.println(file.exists());
	   
	   try (FileReader fr = new FileReader(file); FileWriter fw = new FileWriter(file)) {
		   System.out.println("Write");
		   fw.write("Hot dog!");
		   fw.flush();
		   		   
			System.out.println("Read");	   
		   fr.read(buf);
		   for (char c : buf) {
			   System.out.print(c);
		   }
	   } catch (IOException e) {
		   System.out.println(e);
	   }
	   System.out.println();
   }
   
   /**
    * Use console to display text.
	*/
	public static void newConsole() {
		char[] cp = new char[50];
		Console c = System.console();
		String username;
		
		username = c.readLine("Enter your username: ");
		cp = c.readPassword("Enter your password%s ", ":");
		
		c.format("Your username is %s\n", username);
		for (char letter : cp) {
			c.format("%c", letter);
		}
	}
	
	/**
	 * Using NIO to create a file and directories.
	 */
	 public static void nioTest() {	
		String dir_text = "dirs";
		String text = "dirs\\nio_file.txt";
		String root_text = "java\\oca\\files";
		
		Path dir = Paths.get(dir_text);
		Path path = Paths.get(text);
		Path root = Paths.get(root_text);
		Path res = root.resolve(dir);
			
		System.out.printf("%s exists? %s\n", text, Files.exists(path));
		
		try {
			if (Files.exists(dir)) {
				Files.delete(dir);
			}
			Files.createDirectories(res);
			
			if (!Files.exists(path)) {
				Files.createFile(path);
			} else {
				Files.move(path, res);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
		System.out.printf("%s exists? %s\n", res, Files.exists(res));
		System.out.printf("%s exists? %s\n", text, Files.exists(path));
		
		Path oca = Paths.get("C:\\java\\oca");
		for (Path p : oca) {
			System.out.printf("File name: %s Parent: %s Root: %s\n", oca.getFileName(), oca.getParent(), oca.getRoot());
		}
		
		//Get file attributes
		System.out.println("\nFILE ATTRIBUTES");
		
		try {
			BasicFileAttributes basic = Files.readAttributes(res, BasicFileAttributes.class);
			System.out.println("create: " + basic.creationTime());
			System.out.println("last modified: " + basic.lastModifiedTime());
			System.out.println("last accessed: " + basic.lastAccessTime());
	
		} catch (IOException e) {
			
		}
	 }

	/**
	 * Create a file and then use dos attributes to change attributes.
	 */
	 static void dosTest() {
		System.out.println("\nDOS FILE ATTRIBUTES:\n");
		 Path file = Paths.get("C:/java/oca/test.txt");
		 try {
			 Files.createFile(file);
			 DosFileAttributes dos = Files.readAttributes(file, DosFileAttributes.class);
			 Files.setAttribute(file, "dos:hidden", true);
			 Files.setAttribute(file, "dos:readonly", true);
			 System.out.printf("%s is hidden: %s\n", file, dos.isHidden());
			 System.out.printf("%s is read only: %s\n", file, dos.isReadOnly());
			 
			 Files.setAttribute(file, "dos:hidden", false);
			 Files.setAttribute(file, "dos:readonly", false);
			 System.out.printf("%s is hidden: %s\n", file, dos.isHidden());
			 System.out.printf("%s is read only: %s\n", file, dos.isReadOnly());
			 

			 Files.delete(file);
			 
		 } catch (IOException e) {
			 System.out.println(e);
		 }
	 }
	 
	 /**
	  * Use directory stream to pass through directory.
	  */
	  public static void directoryStreamTest() {
		 try(DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("C:/java"))) {
			for (Path path : stream) {
				System.out.println (path.getFileName());
			}
		 } catch (IOException e) {
			 System.out.println(e);
		 }
	}
	 
	 
	 /**
	  * Extend the simpleFileVisitor to walk through a file tree
	  */
	 static class MyVisitor extends SimpleFileVisitor<Path>{
		 public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			 System.out.println(file.getFileName());
			 return FileVisitResult.CONTINUE;
		 }
	 }
	 
	 /**
	  * Search through a directory.
	  */
	  public static void pathVisitorTest() {
		  MyVisitor dirs = new MyVisitor();
			try {
		 Files.walkFileTree(Paths.get("Java/oca/"), dirs);
			} catch (IOException e) {
				System.out.println(e);
			}	  
	  }
}