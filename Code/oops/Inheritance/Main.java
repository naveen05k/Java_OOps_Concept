package oops.Inheritance;

public class Main {
	public static void main(String[] args) {
		//Box obj = new Box(4,5,6);
		
		BoxWeight obj = new BoxWeight(1,2,3,4);
		Box obj1 = new BoxWeight(1,2,3,4);
		System.out.println(obj1.h);
		System.out.println(obj.l +" "+obj.h+" "+obj.w+" "+obj.weigth);
	}
}
