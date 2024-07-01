package com.newpattern.decorator;

public abstract class ToppingsDecorator extends BasePizza {// is-a BasePizza
	// has-a BasePizza
	protected BasePizza bPizza;

	public ToppingsDecorator(BasePizza pizza) {
		System.out.println("ToppingsDecorator Construted and initializing BasePizza contained object");
		this.bPizza = pizza;
	}
	// inheriting the method from BasePizza and keeping it abstract
	abstract protected int pizzaCost();
}
