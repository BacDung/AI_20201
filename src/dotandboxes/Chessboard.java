package dotandboxes;

import java.util.ArrayList;
import java.util.Arrays;

public class Chessboard implements Cloneable {
	
	final static int BLANK = 0;
	final static int RED = 1;
	final static int BLUE = 2;
	
	private int redScore;
	private int blueScore;
	private int dot;
	private int[][] box;
	private Edge[][] hEdge;
	private Edge[][] vEdge;
	
	public Chessboard(int dot) {
		setDot(dot);
		hEdge = new Edge[dot - 1][dot];
		vEdge = new Edge[dot][dot - 1];
		box = new int[dot - 1][dot - 1];
		fillHEdge(hEdge);
		fillVEdge(vEdge);	
		fillBox(box);
	}
	
	public static int toggleColor(int color) {
		return (color == RED) ? BLUE : RED;
	}

	public void chooseEdge(int a, int x, int y, int color) {
		if(a == 0) {
			hEdge[x][y].setTick(color);
		} else {
			vEdge[x][y].setTick(color);
		}
	}

	public boolean checkEdge(int a, int x, int y) {
		if(a == 0) {
			return hEdge[x][y].getTick() != -1;
		}
		return vEdge[x][y].getTick() != -1;
	}

	// update lại bàn cờ sau mỗi nước đi
	public boolean updateBox(int x_or_y) {
		if (x_or_y == RED) {
			++redScore;
		} else {
			++blueScore;
		}
		for(int i = 0; i < dot - 1; i++) {
			for (int j = 0; j < dot - 1; j++) {
				if (box[i][j] == BLANK
						&& checkEdge(0, i, j)
						&& checkEdge(0, i, j + 1)
						&& checkEdge(1, i, j)
						&& checkEdge(1, i + 1, j)) {
					this.box[i][j] = x_or_y;
					return true;
				}
			}
		}
		return false;
	}

	public Chessboard clone() {
		Chessboard cloned = new Chessboard(dot);

		for (int i = 0; i < dot - 1; i++) {
			for (int j = 0; j < dot; j++) {
				cloned.hEdge[i][j] = new Edge(hEdge[i][j]);
			}
		}

		for (int i = 0; i < dot; i++) {
			for (int j = 0; j < dot - 1; j++) {
				cloned.vEdge[i][j] = new Edge(vEdge[i][j]);
			}
		}

		for (int i = 0; i < dot - 1; i++) {
			System.arraycopy(box[i], 0, cloned.box[i], 0, dot - 1);
		}

		cloned.redScore = redScore;
		cloned.blueScore = blueScore;

		return cloned;
	}

	private void fillHEdge(Edge[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = new Edge(i, j, true);
			}
		}
	}

	private void fillVEdge(Edge[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = new Edge(i, j, false);
			}
		}
	}

	private void fillBox(int[][] arr) {
		for (int[] boxArr : arr) Arrays.fill(boxArr, BLANK);
	}

	public void printHEdge() {
		for (int j = 0; j < dot; j++) {
			for(int i = 0; i < dot - 1; i++) {
				System.out.print(hEdge[i][j].getTick() + " ");
			}
			System.out.println();
		}
	}
	public void printVEdge() {
		for (int j = 0; j < dot - 1; j++) {
			for(int i = 0; i < dot; i++) {
				System.out.print(vEdge[i][j].getTick() + " ");
			}
			System.out.println();
		}
	}
	public void printBox() {
		for (int[] a : box) {
			for(int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}

	public ArrayList<Edge> getAvailableMoves() {
		ArrayList<Edge> result = new ArrayList<>();
		for (int i = 0; i < dot - 1; i++) {
			for (int j = 0; j < dot; j++) {
				if (!checkEdge(0, i, j)) {
					result.add(new Edge(i, j, true));
				}
			}
		}
		for (int i = 0; i < dot; i++) {
			for (int j = 0; j < dot - 1; j++) {
				if (!checkEdge(1, i, j)) {
					result.add(new Edge(i, j, false));
				}
			}
		}
		return result;
	}

	public Chessboard getNewBoard(Edge edge, int color) {
		Chessboard result = clone();
		if(edge.isHorizontal()) {
			result.chooseEdge(0, edge.getX(), edge.getY(), color);
		}
		else {
			result.chooseEdge(1, edge.getX(), edge.getY(), color);
		}
		return result;
	}

	private int getEdgeCount(int i, int j) {
		int count = 0;
		if (checkEdge(0, i, j)) {
			count++;
		}
		if (checkEdge(0, i, j + 1)) {
			count++;
		}
		if (checkEdge(1, i, j)) {
			count++;
		}
		if (checkEdge(1, i + 1, j)) {
			count++;
		}
		return count;
	}
        
        public Edge nextMove() {
            for(int i = 0; i < dot - 1; i++) {
                for(int j = 0; j < dot - 1; j++) {
                    if (getEdgeCount(i, j) == 3) {
                        if (!checkEdge(0, i, j)) {
                            return new Edge(i, j, true);
                        }
                        if (!checkEdge(0, i, j + 1)) {
                            return new Edge(i, j+1, true);
                        }
                        if (!checkEdge(1, i, j)) {
                            return new Edge(i, j, false);
                        }
                        if (!checkEdge(1, i + 1, j)) {
                            return new Edge(i + 1, j, false);
                        }
                    }
                }
            }
            return null;
        }

	public int getBoxCount(int sides) {
		int count = 0;
		for (int i = 0; i < dot - 1; i++) {
			for (int j = 0; j < dot - 1; j++) {
				if (getEdgeCount(i, j) == sides) {
					++count;
				}
			}
		}
		return count;
	}

	public int getRedScore() {
        return redScore;
    }

    public int getBlueScore() {
        return blueScore;
    }
	
    public int getScore(int color) {
        return (color == RED) ? redScore : blueScore;
    }

	public int[][] getBox() {
		return this.box;
	}

	public int getDot() {
		return this.dot;
	}

	public Edge[][] getHEdge() {
		return this.hEdge;
	}

	public Edge[][]  getVHedge() {
		return this.vEdge;
	}

	public void setDot(int dot) {
		this.dot = dot;
	}

	public void setHEdge(Edge[][] edge) {
		this.hEdge = edge;
	}

	public void setVEdge(Edge[][] edge) {
		this.vEdge = edge;
	}
}
