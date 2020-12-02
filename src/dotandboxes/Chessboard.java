package dotandboxes;


public class Chessboard {
	
	final static int BLANK = 0;
	final static int POINTX = 1;
	final static int POINTY = 2;
	
	
	public Chessboard(int dot) {
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
		

	
	public void chooseEdge(int a, int x, int y) {
		if(a == 0)
			hEdge[x][y].setTick(true);
		else
			vEdge[x][y].setTick(true);
	}
	

	
	public boolean checkEgde(int a, int x, int y) {
		if(a == 0) {
			if(hEdge[x][y].getTick() == true) {
				return false;
			}
			else
				return true;
		}
		else {
			if(vEdge[x][y].getTick() == true) {
				return false;
			}
			else
				return true;
		}
	}

	
	// update lại bàn cờ sau mỗi nước đi
	public boolean updateBox(int x_or_y) {
		for(int i = 0; i < dot - 1; i++) 
			for(int j = 0; j < dot - 1; j++) {
				if(hEdge[i][j].getTick() == true && hEdge[i][j + 1].getTick() == true && vEdge[i][j].getTick() == true && vEdge[i + 1][j].getTick() == true ) {
					this.box[i][j] = x_or_y;
					return true;
				}
			}
		return false;
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
