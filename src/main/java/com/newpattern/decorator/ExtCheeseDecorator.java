package com.newpattern.decorator;

public class ExtCheeseDecorator extends ToppingsDecorator {
	
	public ExtCheeseDecorator(BasePizza pizza) {
		super(pizza);
		// cheese cost
		cost = 10;
		System.out.println("ExtCheeseDecorator Constructed");
	}
	
	@Override
	protected int pizzaCost() {
		int basePizzaCost = bPizza.pizzaCost();
		System.out.println("returning base pizza + extra cheese cost");
		return basePizzaCost + this.cost;
	}
}
