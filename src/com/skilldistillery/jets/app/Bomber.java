package com.skilldistillery.jets.app;

public class Bomber extends Jet implements BombsAway{

	public Bomber(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public void fly() {
		System.out.println(this.getModel()+ " is flying, enroute to enemy target");
	}
	@Override
	public void dropBombs() {
		System.out.println(this.getModel()+" is dropping bombs");
	}

}
