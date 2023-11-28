package oops.Polymorphism;

public class Number {
	int sum(int a, int b) {
		return a + b;
	}

	int sum(int a, int b, int c) {
		return a + b + c;
	}

	public static void main(String[] args) {
		Number obj = new Number();
		obj.sum(1, 2);
		obj.sum(1, 2, 3);
		
	}
}
