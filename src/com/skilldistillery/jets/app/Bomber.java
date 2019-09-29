package com.skilldistillery.jets.app;

public class Bomber extends Jet implements BombsAway {

	public Bomber(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void taxi() {
		System.out.println(this.getModel() + " is taxiing for takeoff, ready to go");
	}

	@Override
	public void fly() {
		System.out.println(this.getModel() + " is leveling out, awaiting orders");
	}

	public void dropBombs() {
		System.out.println(this.getModel() + " is bombs awaaaaaaay..");
	}

}
