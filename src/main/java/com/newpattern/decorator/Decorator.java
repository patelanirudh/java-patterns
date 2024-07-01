package com.newpattern.decorator;

public class Decorator {
	
	public static void main(String[] args) {
		BasePizza pizza1 = new VegDelight();
		pizza1 = new ExtCheeseDecorator(pizza1);
		System.out.println("Total VegDelight + Extra Cheese Costing  = " + pizza1.pizzaCost());
		
		BasePizza pizza2 = new Farmhouse();
		pizza2 = new ExtCheeseDecorator(new MushroomDecorator(pizza2));
		System.out.println("Total Farmhouse + Extra Cheese + Mushroom Costing  = " + pizza2.pizzaCost());
	}

}
