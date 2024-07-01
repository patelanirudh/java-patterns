package com.newpattern.decorator;

public class MushroomDecorator extends ToppingsDecorator {
	
	public MushroomDecorator(BasePizza pizza) {
		super(pizza);
		cost = 30;
		System.out.println("MushroomDecorator Constructed");
	}
	
	@Override
	protected int pizzaCost() {
		int basePizzaCost = bPizza.pizzaCost();
		System.out.println("returning base pizza + mushroom toppings cost");
		return basePizzaCost + cost;
	}
}
