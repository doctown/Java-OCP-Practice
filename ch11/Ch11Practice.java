/**
 * Practice concepts in chapter 11.
 */
package ch11;

import java.util.*;

public class Ch11Practice {
	private class Movie implements Comparable<Movie> {
		private String title;
		private String genre;
		
		Movie(String title) {
			this.title = title;
		}
		
		public String getTitle() {
			return title;
		}
		
		public void setGenre(String g) {
			genre = g;
		}
		
		public String getGenre() {
			return genre;
		}
		
		public int compareTo(Movie m) {
			return this.getTitle().compareTo(m.getTitle());
		}
		
		public String toString() {
			return this.title;
		}
		
		public int Hashcode() {
			return 17 * title.charAt(0) - 'A';
		}
		
		public boolean equals(Object o) {
			if (!(o instanceof Movie)) {
				return false;
			}
			if (!((Movie) o).getTitle().equals(this.getTitle())) {
				return false;
			}
			return true;
		}
	}
	
	static class CompareGenre implements Comparator<Movie> {
		public int compare(Movie m1, Movie m2) {
			return m1.getGenre().compareTo(m2.getGenre());
		}
	}
	
	public static void main(String[] args) {
		Ch11Practice ch = new Ch11Practice();
		ch.arrayListTest();
		ch.setTest();
	}
	
	public void setTest() {
		Scanner input = new Scanner(System.in);
		String line = "";
		HashSet<Movie> set = new HashSet<>();
		while (input.hasNext()) {
			set.add(new Movie(input.nextLine()));
		}	
		System.out.println(set);
	}
	
	public void arrayListTest() {
		List<Movie> list = new ArrayList<>();
		list.add(new Movie("Back to the future"));
		list.add(new Movie("Star Wars"));
		list.add(new Movie("InsideOut"));
		
		list.get(0).setGenre("Action");
		list.get(1).setGenre("Action");
		list.get(2).setGenre("Family");
		System.out.println("My list of favorite movies are " + list);
		Collections.sort(list);
		System.out.println("This is my list sorted: ");
		for (Movie m : list) {
			System.out.printf("%-20s\n", m);
		}
		CompareGenre c = new CompareGenre();
		Collections.sort(list, c);
		//finish list and try others like set and hash maps
		for (Movie m : list) {
			System.out.printf("%20s\n", m);
		}
	}
	
}