package oops.StaticKeyword;

public class StaticBlock {
	static int a = 2;
	static int b;

	static {
		System.out.println("THis is static block");
		b = a * 5;
	}

	public static void main(String[] args) {
		StaticBlock obj = new StaticBlock();
		System.out.println(StaticBlock.a + " " + StaticBlock.b);
	}
}
