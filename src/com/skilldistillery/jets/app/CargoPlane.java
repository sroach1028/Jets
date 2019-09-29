package com.skilldistillery.jets.app;

public class CargoPlane extends Jet implements CargoCarrier{

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void taxi() {
		System.out.println(this.getModel()+ " is taxiing for takeoff, ready to go");
	}
	@Override
	public void fly() {
		System.out.println(this.getModel()+" is enroute delivering the precious cargo");
	}
	
	public void loadCargo() {
		System.out.println(this.getModel()+" loading cargo");// TODO Auto-generated method stub
		
	}
	

}
