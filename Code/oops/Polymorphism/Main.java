package oops.Polymorphism;

public class Main {
	public static void main(String[] args) {
		Shapes shapes = new Shapes();
		Shapes circle = new Circle();
		Shapes square = new Square();
		
		square.area();
		
		square.toString();
	}
	

}
