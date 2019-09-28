package com.skilldistillery.jets.app;

public class FighterJet extends Jet implements CombatReady{

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		System.out.println("Fighter jet is Flying");
	}
	
	public void fight() {
		System.out.println("fighter jet is fighting");
		// TODO Auto-generated method stub
		
	}

}
