package oops.Interface;

public class Car implements Engine, Brake, Media {

	@Override
	public void brake() {
		// TODO Auto-generated method stub
		System.out.println("I brake ");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("I stop");
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("I start");
	}

	@Override
	public void acc() {
		// TODO Auto-generated method stub
		System.out.println("I accelerate");
	}

}
