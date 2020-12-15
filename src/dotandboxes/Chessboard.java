package dotandboxes;

import java.util.ArrayList;

public class Chessboard implements Cloneable {
	
	final static int BLANK = 0;
	final static int RED = 1;
	final static int BLUE = 2;
	
	private int redScore, blueScore;
	
	public Chessboard(int dot) {
		setDot(dot);
		hEdge = new Edge[dot - 1][dot];
		vEdge = new Edge[dot][dot - 1];
		box = new int[dot - 1][dot - 1];
		fillHEdge(hEdge);
		fillVEdge(vEdge);	
		fillBox(box);
	}
	
	private int dot;
	private int[][] box;
	private Edge[][] hEdge;
	private Edge[][] vEdge;
//	private int x;
//	private int y;
		
	public int getRedScore() {
        return redScore;
    }

    public int getBlueScore() {
        return blueScore;
    }
	
    public int getScore(int color) {
        if(color == RED) return redScore;
        else return blueScore;
    }
    
    public static int toggleColor(int color) {
        if(color == RED) return BLUE;
        else return RED;
    }
    
	public void chooseEdge(int a, int x, int y, int color) {
		if(a == 0)
			hEdge[x][y].setTick(color);
		else
			vEdge[x][y].setTick(color);
	}
	
	public boolean checkEgde(int a, int x, int y) {
		if(a == 0) {
			if(hEdge[x][y].getTick() != -1) {
				return false;
			}
			else
				return true;
		}
		else {
			if(vEdge[x][y].getTick() != -1) {
				return false;
			}
			else
				return true;
		}
	}

	
	// update lại bàn cờ sau mỗi nước đi
	public boolean updateBox(int x_or_y) {
		if (x_or_y == 1) ++redScore;
		else ++blueScore; 
		for(int i = 0; i < dot - 1; i++) 
			for(int j = 0; j < dot - 1; j++) {
				if(box[i][j] == BLANK && hEdge[i][j].getTick() != -1 && hEdge[i][j + 1].getTick() != -1 && vEdge[i][j].getTick() != -1 && vEdge[i + 1][j].getTick() != -1) {
					this.box[i][j] = x_or_y;
					return true;
				}
			}
		return false;
	}
	
	
	public Chessboard clone() {
        Chessboard cloned = new Chessboard(dot);

        for(int i=0; i<dot-1; i++)
            for(int j=0; j<dot; j++)
                cloned.hEdge[i][j] = new Edge(hEdge[i][j]);

        for(int i=0; i<dot; i++)
            for(int j=0; j<dot-1; j++)
                cloned.vEdge[i][j] = new Edge(vEdge[i][j]);

        for(int i=0; i<dot-1; i++)
            for(int j=0; j<dot-1; j++)
                cloned.box[i][j] = box[i][j];

        cloned.redScore = redScore;
        cloned.blueScore = blueScore;

        return cloned;
    }
	
    private void fillHEdge(Edge[][] array) {
        for(int i = 0; i < array.length; i++) 
            for(int j = 0; j < array[i].length; j++) {
                array[i][j] = new Edge(i, j, true);
            }
    }
    
    private void fillVEdge(Edge[][] array) {
        for(int i = 0; i < array.length; i++) 
            for(int j = 0; j < array[i].length; j++) {
                array[i][j] = new Edge(i, j, false);
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
    
    public ArrayList<Edge> getAvailableMoves() {
        ArrayList<Edge> ret = new ArrayList<Edge>();
        for(int i=0; i<dot-1;i++)
            for(int j=0; j<dot; j++)
                if(hEdge[i][j].getTick() == -1)
                    ret.add(new Edge(i,j,true));
        for(int i=0; i<dot; i++)
            for(int j=0; j<dot-1; j++)
                if(vEdge[i][j].getTick() == -1)
                    ret.add(new Edge(i,j,false));
        return ret;
    }
    
    public Chessboard getNewBoard(Edge edge, int color) {
        Chessboard ret = clone();
        if(edge.isHorizontal())
            ret.chooseEdge(0, edge.getX(), edge.getY(), color);
        else
            ret.chooseEdge(1, edge.getX(), edge.getY(), color);
        return ret;
    }
	
    private int getEdgeCount(int i, int j) {
        int count = 0;
        if(hEdge[i][j].getTick() != -1) count++;
        if(hEdge[i][j+1].getTick() != -1) count++;
        if(vEdge[i][j].getTick() != -1) count++;
        if(vEdge[i+1][j].getTick() != -1) count++;
        return count;
    }
    
    public int getBoxCount(int sides) {
        int count = 0;
        for(int i=0; i<dot-1; i++)
            for(int j=0; j<dot-1; j++) {
                if(getEdgeCount(i, j) == sides)
                    ++count;
            }
        return count;
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
