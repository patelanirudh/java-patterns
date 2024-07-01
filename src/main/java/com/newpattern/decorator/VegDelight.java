package com.newpattern.decorator;

public class VegDelight extends BasePizza {
	
	public VegDelight() {
		System.out.println("VegDelight pizza constructed");
		cost = 30;
	}
	
	@Override
	protected int pizzaCost() {
		System.out.println("returning VegDelight pizza cost");
		return cost;
	}

}
