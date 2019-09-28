package com.skilldistillery.jets.app;

public class Bomber extends Jet implements BombsAway{

	public Bomber(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public void fly() {
		System.out.println(this.getModel()+ " is enroute to enemy target, awaiting orders");
	}
	@Override
	public void dropBombs() {
		System.out.println(this.getModel()+" is bombs away");
	}

}
