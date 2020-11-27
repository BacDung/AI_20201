package dotandboxes;



public class Game {
	public Game(int dot) {
		this.chessboard = new Chessboard(dot);
		this.player1 = new Player();
		this.ai = new Ai();
	}
	private Chessboard chessboard;
	private Player player1;
	private Player ai;
	
	private void play(Player player) {
		int a = player.chooseEgde();
		int x, y;
		do {
			x = player.chooseCoordinates("x");
			y = player.chooseCoordinates("y");
			if(!chessboard.checkEgde(a, x, y))
				System.out.println("cạnh đó đã được chọn vui lòng nhập lại: ");
		}
		while(!chessboard.checkEgde(a, x, y));
		chessboard.chooseEdge(a, x, y);
		chessboard.updateBox(1);
		
	}
	
	public void start() { 
		play(player1);
		chessboard.printHEdge();
		System.out.println();
		chessboard.printVEdge();
		System.out.println();
		chessboard.printBox();
		play(ai);
		chessboard.printHEdge();
		chessboard.printVEdge();
		chessboard.printBox();
		
	}
	
	public static void main(String[] args) {
		Game a = new Game(5);
		a.start();
	}	
	
	
	
	
	
	
	
	
	
	
	
	//chon canh
//	public int chooseEgde() {
//		 Scanner sc = new Scanner(System.in);
//		 System.out.println("chon canh ngang nhap 0 chon canh doc nhap 1");
//		 int a = sc.nextInt();
//		 sc.close();
//		 return a;
//		 
//	}
//	// chon toa do cho canh
//	public Egde chooseCoordinates() {
//		Egde egde = new Egde();
//		System.out.println("nhap toa do canh");
//		Scanner sc = new Scanner(System.in);
//		int x = sc.nextInt();
//		int y = sc.nextInt();
//		egde.setX(x);
//		egde.setY(y);
//		egde.setTick(true);
//		sc.close();
//		return egde;
//	}
//	public void chooseHEdge(Egde egde) {
//		if(checkHEgde(egde))
//			chessboard.hEdge[egde.getX()][egde.getY()] = egde;
//		else
//			System.out.println("canh do da duoc chon");
//	}
//	public boolean checkHEgde(Egde egde) {
//			Egde[][] e = chessboard.getHEdge();
//		if(e[egde.getX()][egde.getY()].getTick() == true)
//			return false;
//		else
//			return true;
//	}
//	public void start() {
//		int canh = chooseEgde();
//		if(canh == 0)
//			chooseHEdge(chooseCoordinates());
//		if(canh == 1)
//			chessboard.chooseVEdge(chooseCoordinates());
//	}	

}
