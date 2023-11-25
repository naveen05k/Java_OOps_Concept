package oops.Inheritance;

public class BoxWeight extends Box {
	int weigth;

	BoxWeight() {
		this.weigth = 12;
	}

	public BoxWeight(int l, int h, int w,int weigth) {
		super(l, h, w);// call the parent class constructor
		// used to initialise in parent class
		this.weigth = weigth;
	}

	
}
