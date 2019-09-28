package com.skilldistillery.jets.app;

public class PropPlane extends Jet{

	public PropPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	
	}
	@Override
	public void fly() {
		System.out.println("prop plane is flying");
	}

}
