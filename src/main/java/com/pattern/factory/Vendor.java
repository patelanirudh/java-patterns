package com.pattern.factory;

public interface Vendor {
	// static can be made private
	static String greetings() {
		return "Welcome to vendor interface !!!";
	}
	
	// we not even have private concrete methods from Java 9 onwards
	
	public default void defaultMethod() {
		System.out.println("This Vendor interface default method()");
		// greetings(); if static function is made private
	}
	
	public abstract void sendMessage();
}
