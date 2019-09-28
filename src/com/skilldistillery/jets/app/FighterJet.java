package com.skilldistillery.jets.app;

public class FighterJet extends Jet implements CombatReady{

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println(this.getModel()+" is flying, looking to fight");
	}
	
	public void fight() {
		System.out.println(this.getModel()+ " is fighting...pew pew");
		
	}

}
