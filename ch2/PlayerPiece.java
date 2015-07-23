public class PlayerPiece extends GameShape implements Animated{
	public void animate() { };
	public void doShape() { 
		System.out.println("doShape: Inside PlayerPiece");
	}
	
	public void doShape(GameShape g) {
		System.out.print("doShape: Inside PlayerPiece - g ->");
		g.doShape();
	}
	
	PlayerPiece doGame() {
		return null;
	}
	
	public void doShape(PlayerPiece p) {
		System.out.println("doShape: Inside PlayerPiece - p");
		
	}
}