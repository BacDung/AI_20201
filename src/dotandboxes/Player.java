package dotandboxes;

public class Player {
	public Player() {
		
	}
	private String name;
	private int age;
	private int point;
	
	public String getName() {
		return this.name;
	}
	public int getAge()	{
		return this.age;
	}
	public int getPoint() {
		return this.point;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
