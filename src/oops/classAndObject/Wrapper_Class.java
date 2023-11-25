package oops.classAndObject;

public class Wrapper_Class {
	class Ass {
		final int num = 10;
		String name;

		public Ass(String name) {
			this.name = name;
		}

		@Override
		protected void finalize() throws Throwable {
			super.finalize();
			System.out.println("oBj destroyed");
		}
	}

	public static void main(String[] args) {
		
		Ass as;
		for(int i=0;i<100;i++) {
			//as  =new Ass("nff");
		}
		System.gc();
		int a = 3, b = 4;
		Integer num = 45;
		num.getClass();
		System.out.println(num.getClass());
		swap(a, b);
		System.out.println(a + " " + b);

//		Wrapper class to primitive (unboxing)
		Integer no = 33;
		int i = no.intValue();
		System.out.println(i);

//		Primitive to wrapper class (Autoboxing)
		int in = 4;
		Integer op = Integer.valueOf(in);
		System.out.println(op);

		int num1 = 110;
		int num2 = 55;

		int temp = num1;
		num1 = num2;
		num2 = temp;
		System.out.println(num1 + " " + num2);

		// final keyword cannot be modified final
		final int salary = 23333333;
		// Ass na = new Ass("sss");
		// na.name = "kumaaa";

		/// garbage collection

		int ko = 233;
		ko = 32323;
		System.out.println(ko);

	}

	static void swap(int num1, int num2) {
		int temp = num1;
		num1 = num2;
		num2 = temp;
		System.out.println(num1 + " " + num2);
	}
}
