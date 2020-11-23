package dotandboxes;

import java.util.Scanner;

public class Player {
	public Player() {
		setName("thai");
		setAge(20);
		setPoint(0);
	}
	private String name;
	private int age;
	private int point;
	Scanner sc = new Scanner(System.in);
	
	public int chooseEgde() {
		System.out.println("chọn cạnh ngang nhập 0 cạnh dọc nhâp 1");
		int canh = sc.nextInt();
		return canh;
	}
	public int chooseCoordinates(String x_or_y) {
		System.out.println("nhập tọa độ " + x_or_y + ": ");
		int x = sc.nextInt();
		return x;
	}
	public static void main(String[] args) {
		Player a = new Player();
		int c = a.chooseEgde();
		int b = a.chooseCoordinates("x");
		int d = a.chooseCoordinates("y");
		System.out.println(c + b + d);
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
