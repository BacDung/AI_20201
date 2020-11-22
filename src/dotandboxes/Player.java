package dotandboxes;

import java.util.Scanner;

public class Player {
	public Player() {
		
	}
	private String name;
	private int age;
	private int point;
	
	public int chooseEgde() {
		System.out.println("chon canh ngang nhap 0 canh doc nhap 1");
		Scanner sc = new Scanner(System.in);
		int canh = sc.nextInt();
		sc.close();
		return canh;
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
