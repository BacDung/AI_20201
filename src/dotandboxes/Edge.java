package dotandboxes;

public class Edge {
	
	public Edge() {
		x = y = tick = -1;
	}
	
	public Edge(int x, int y, boolean isHorizontal) {
		this.x = x;
		this.y = y;
		this.tick = -1;
		this.isHorizontal = isHorizontal;
	}
	
	public Edge(Edge e) {
		this.x = e.x;
		this.y = e.y;
		this.isHorizontal = e.isHorizontal;
		this.tick = e.tick;
	}
	
	private int tick;
	private boolean isHorizontal;
	private int x;
	private int y;
	
	public boolean isHorizontal() {
		return isHorizontal;
	}
	
	public int getTick() {
		return this.tick;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void setTick(int tick) {
		this.tick = tick;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.x = y;
	}
}
