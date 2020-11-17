package dotandboxes;

public class Chessboard {
	public Chessboard(int dot) {
		setDot(dot);
		boolean a[][] = new boolean[getDot()][getDot()];
		setChessboard(a);
		setX(0);
		setY(0);
	}
	private int dot;
	private boolean[][] chessboard;
	private int X;
	private int Y;
	
	
	public void printChessbroard() {
		for(int i = 0; i < getDot(); i++) {
			for(int j = 0; j < getDot(); j++) {
				System.out.print(chessboard[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Chessboard a = new Chessboard(5);
		a.printChessbroard();
	}
	
	public int getDot() {
		return this.dot;
	}
	public boolean[][] getChessboard(){
		return this.chessboard;
	}
	public int getX() {
		return this.X;
	}
	public int getY() {
		return this.Y;
	}
	public void setDot(int dot) {
		this.dot = dot;
	}
	public void setChessboard(boolean[][] chessboard) {
		this.chessboard = chessboard;
	}
	public void setX(int x) {
		this.X = x;
	}
	public void setY(int y) {
		this.Y = y;
	}
}
