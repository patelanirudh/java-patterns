package com.pattern.factory;

public class SMSVendor implements Vendor {
	
	public SMSVendor() {
		 System.out.println("SMSVendor Ctor : " + Vendor.greetings());
	}
	
	@Override
	public void sendMessage() {
		System.out.println("This is SMSVendor sendMessage()");
	}

}
