package oops.classAndObject;

public class Packages {

	public static void main(String[] args) {
		A obj = new A(32, "fe");
		System.out.println(obj.toString());
		
	}

}

class A {
	int no;
	String name;

	public A() {

	}

	A(int num, String nam) {
		this.name = nam;
		this.no = num;
	}
}