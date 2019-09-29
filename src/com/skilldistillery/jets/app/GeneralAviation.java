package com.skilldistillery.jets.app;

public class GeneralAviation extends Jet{

	public GeneralAviation(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	
	}
	@Override
	public void taxi() {
		System.out.println(this.getModel()+" is taxiing for takeoff, ready to go");
	}
	
	@Override
	public void fly() {
		System.out.println(this.getModel()+" has completed takeoff, trying not to crash");
	}

}
