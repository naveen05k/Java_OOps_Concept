package oops.AccessModifier;

public class A {
	private int num;
	private String name;
	private int[] arr;

	public A() {
		super();
		// TODO Auto-generated constructor stub
	}

	public A(int num, String name) {
		super();
		this.num = num;
		this.name = name;
		this.arr = new int[num];
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

}
