package oops.Inheritance;

public class Boxprice extends BoxWeight {

	int cost;

	Boxprice() {
		super();
		this.cost = 1;
	}

	Boxprice(Boxprice other) {
		this.cost = other.cost;
	}

	public Boxprice(int l, int h, int w, int weigth,int cost) {
		super(l, h, w, weigth);
		this.cost = cost;
	}
	
	
	void cost() {
		System.out.println("This is BOx price");
	}
}
