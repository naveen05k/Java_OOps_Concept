package oops.Inheritance;

public class Box {

	int l;
	int h;
	int w;
	
	public Box() {
		super();
		this.l = 1;
		this.h = 1;
		this.w = 1;
	}
	
	Box(int side){
		this.l=side;
		this.h=side;
		this.w=side;
	}

	public Box(int l, int h, int w) {
		super();
		this.l = l;
		this.h = h;
		this.w = w;
	}
	Box(Box old){
		this.l=old.l;
		this.h=old.h;
		this.w=old.w;}
	
	public void infoDisplay() {
		System.out.println("Running");
	}
	
	
	
}
