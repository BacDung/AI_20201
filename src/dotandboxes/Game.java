package dotandboxes;

public class Game {
	public Game(int dot) {
		this.chessbroad = new Chessboard(dot);
		this.player = new Player();
		this.ai = new Ai();
	}
	private Chessboard chessbroad;
	private Player player;
	private Ai ai;
	
	public void chooseDot() {
		
	}
}
