package com.pattern.factory;

public class EmailVendor implements Vendor {
	
	public EmailVendor() {
		System.out.println("EmailVendor Ctor : " + Vendor.greetings());
	}
	
	@Override
	public void sendMessage() {
		System.out.println("This is EmailVendor sendMessage()");
	}

}
