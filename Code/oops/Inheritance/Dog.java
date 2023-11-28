package oops.Inheritance;

public class Dog extends Animal {
	String color = "white";
	
	void println() {
		System.out.println("Color form dog class"+color);
		System.out.println("color form parent class "+super.color );
	}
}
