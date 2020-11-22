package dotandboxes;

public class Edge {
	
	public Edge() {
		tick = false;
		x = y = -1;
	}
	
	private boolean tick;
	private int x;
	private int y;
	
	public boolean getTick() {
		return this.tick;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void setTick(boolean tick) {
		this.tick = tick;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.x = y;
	}
}
