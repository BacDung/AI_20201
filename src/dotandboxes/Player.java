package dotandboxes;

import java.util.Scanner;

public class Player {
	private int id;
	private String name;
	private int age;
	private int point;

	public Player() {
		setName("thai");
		setAge(20);
		setPoint(0);
	}

	Scanner sc = new Scanner(System.in);
	
	public int chooseEdge() {
		System.out.println("chọn cạnh ngang nhập 0 cạnh dọc nhập 1");
		return sc.nextInt();
	}

	public int chooseCoordinates(String x_or_y) {
		System.out.println("nhập tọa độ " + x_or_y + ": ");
		return sc.nextInt();
	}

	public static void main(String[] args) {
		Player a = new Player();
		int b = a.chooseEdge();
		int c = a.chooseCoordinates("x");
		int d = a.chooseCoordinates("y");
		System.out.println(b + c + d);
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

	public int getAge()	{
		return this.age;
	}

	public int getPoint() {
		return this.point;
	}
	
	public void setId(int id) {
		this.id = id;
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
