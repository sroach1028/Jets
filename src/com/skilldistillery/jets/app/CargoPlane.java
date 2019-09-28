package com.skilldistillery.jets.app;

public class CargoPlane extends Jet implements CargoCarrier{

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		System.out.println("Cargo plane is flying");
	}
	
	public void loadCargo() {
		System.out.println("cargo jet loading cargo");// TODO Auto-generated method stub
		
	}
	

}
