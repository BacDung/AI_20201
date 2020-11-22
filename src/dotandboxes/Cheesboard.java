package dotandboxes;


public class Cheesboard {
	
	final static int BLANK = 0;
	final static int POINTX = 1;
	final static int POINTY = 2;
	
	
	public Cheesboard(int dot) {
		setDot(dot);
		hEdge = new Edge[dot - 1][dot];
		vEdge = new Edge[dot][dot - 1];
		box = new int[dot - 1][dot - 1];
		fill(hEdge);
		fill(vEdge);	
		fillBox(box);
	}
	
	private int dot;
	private int[][] box;
	private Edge[][] hEdge;
	private Edge[][] vEdge;
//	private int x;
//	private int y;
	
	public static void main(String[] args) {
		Cheesboard a = new Cheesboard(5);
		a.chooseHEdge(0, 0);
		a.updateBox(POINTX);
		a.chooseVEdge(0, 0);
		a.updateBox(POINTY);
		a.chooseHEdge(0, 1);
		a.updateBox(POINTX);
		a.chooseVEdge(1, 0);
		a.updateBox(POINTY);
		a.printBox();
		
	}
	

	
	public void chooseHEdge(int x, int y) {
		hEdge[x][y].setTick(true);
	}
	
	public void chooseVEdge(int x, int y) {
		vEdge[x][y].setTick(true);
	}
	
	public boolean checkHEgde(int x, int y) {
		if(hEdge[x][y].getTick() == true) {
			System.out.println("Cạnh đấy được trọn rồi ông nội");
			return false;
		}
		else
			return true;
	}
	public boolean checkVEgde(int x, int y) {
		if(vEdge[x][y].getTick() == true) {
			System.out.println("Cạnh đấy được trọn rồi ông nội");
			return false;
		}
		else
			return true;
	}
	
	// update lại bàn cờ sau mỗi nước đi
	public void updateBox(int player) {
		for(int i = 0; i < dot - 1; i++) 
			for(int j = 0; j < dot - 1; j++) {
				if(hEdge[i][j].getTick() == true && hEdge[i][j + 1].getTick() == true && vEdge[i][j].getTick() == true && vEdge[i + 1][j].getTick() == true )
					this.box[i][j] = player;
			}
	}
	
	
    private void fill(Edge[][] array) {
        for(int i = 0; i < array.length; i++) 
            for(int j = 0; j < array[i].length; j++) {
                array[i][j] = new Edge();
        		array[i][j].setX(i);
        		array[i][j].setY(j);
            }
    }
    private void fillBox(int[][] arr) {
    	for(int i = 0; i < arr.length; i++)
    		for(int j = 0; j < arr[i].length; j++) {
    			arr[i][j] = BLANK;
    		}
    }
    
    public void printHEdge() {
    	for(int j = 0; j < dot; j++) {
    		for(int i = 0; i < dot - 1; i++) 
    			System.out.print(hEdge[i][j].getTick() + " ");   		
    		System.out.println();
    	}
    }
    public void printVEdge() {
    	for(int j = 0; j < dot - 1; j++) {
    		for(int i = 0; i < dot; i++) 
    			System.out.print(vEdge[i][j].getTick() + " ");   		
    		System.out.println();
    	}
    }
    public void printBox() {
    	for(int a[] : box) { 
    		for(int b : a) 
    			System.out.print(b + " ");
    		System.out.println();
    	}
    }
	
	
	public int[][] getBox() {
		return this.box;
	}
	public int getDot() {
		return this.dot;
	}
	public Edge[][] getHEdge(){
		return this.hEdge;
	}

	public Edge[][]  getVHedge(){
		return this.vEdge;
	}
	public void setDot(int dot) {
		this.dot = dot;
	}
	public void setHEdge(Edge[][] egde){
		this.hEdge = egde;
	}
	public void setVEdge(Edge[][] egde){
		this.vEdge = egde;
	}


}
