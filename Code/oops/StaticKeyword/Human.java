package oops.StaticKeyword;

public class Human {
	int no;
	String name;
	int salary;
	
	
	static void fun(){
		///cannot use this inside the static 
		// bcoz static no depent a instance of class
		//System.out.println(this.age);
	}

	public Human(int no, String name, int salary) {
		super();
		this.no = no;
		this.name = name;
		this.salary = salary;
	}

	static void display() {
		System.out.println("Display");
	}
}
