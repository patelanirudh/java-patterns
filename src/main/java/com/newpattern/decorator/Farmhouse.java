package com.newpattern.decorator;

public class Farmhouse extends BasePizza {
	
	public Farmhouse() {
		System.out.println("Farmhouse pizza is constructed");
		cost = 50;
	}
	
	@Override
	protected int pizzaCost() {
		System.out.println("returning Farmhouse pizza cost");
		return cost;
	}
}
