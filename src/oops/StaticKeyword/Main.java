package oops.StaticKeyword;

import oops.packages2.Greeting;

public class Main {
	public static void main(String[] args) {
		Human naveen = new Human(22, "naveen", 32323);
		Human kumar = new Human(22, "kuamrnull", 32323);

		System.out.println(naveen.no);
		welcome();
		
	}

	static void welcome() { // with out creating instance of class;
		System.out.println("Welcome");
		Main obj = new Main();
		obj.greeting();
	}
	
	
	void fun() {
		greeting();
	}

	void greeting() {////  belong to instance of object 
		System.out.println("Non static ");
	}

}
