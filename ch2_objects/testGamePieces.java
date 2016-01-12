public class testGamePieces {
	static int num = 0;
	
	public static void main(String[] args) {
		PlayerPiece player = new PlayerPiece();
		Object o = player;
		GameShape g = new GameShape(3);
		GameShape gp = player;
		Animated a = player;
		GameShape gtop  = new PlayerPiece();
		
		player.doShape(player); //test polymorphism
		player.doShape(g);
		player.doShape(gtop);
		gp.doShape();
		g.doShape();
		a.animate();
		player.animate();
		System.out.println();
		System.out.println("" + g.getNum());
		System.out.println("" + gp.getNum());
		
		++num;
	}		
}	