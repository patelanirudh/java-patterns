package com.pattern.factory;

public interface Vendor {
	static String greetings() {
		return "Welcome to vendor interface !!!";
	}
	
	public default void defaultMethod() {
		System.out.println("This Vendor interface default method()");
	}
	
	public abstract void sendMessage();
}
