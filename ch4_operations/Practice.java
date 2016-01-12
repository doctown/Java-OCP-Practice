
class Practice {
	class Suburu extends Vehicle {}
	class Vehicle {}
	public static void instance() {
		Suburu s = new Suburu();
		Vehicle v = new Vehicle();
		
		System.out.println(s instanceof Vehicle);
	}
	
	public static void main(String[] args) {
		int x = 5;
		x *= 4 + 5;
		System.out.println(5.0 == 5d);
		
		instance();
	}
}