package com.skilldistillery.jets.app;

public class UAV extends Jet implements SpyPlane{

	public UAV(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	@Override
	public void taxi() {
		System.out.println(this.getModel()+ " is taxiing for takeoff, ready to go");
	}
	@Override
	public void fly() {
		System.out.println(this.getModel()+ " is airborne..who's flying this thing?");
	}
	
	public void surveil() {
		System.out.println(this.getModel()+ " has eyes on target, performing surveillance");
	}

}
