package com.skilldistillery.jets.app;

public class GeneralAviation extends Jet{

	public GeneralAviation(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	
	}
	@Override
	public void fly() {
		System.out.println(this.getModel()+" is flying, trying not to crash");
	}

}
