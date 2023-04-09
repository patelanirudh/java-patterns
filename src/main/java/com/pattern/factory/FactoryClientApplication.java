package com.pattern.factory;

public class FactoryClientApplication {
	
	public static void main(String[] args) {
		// Vendor concreteVendorObject = MessageFactory.createVendor(VendorType.SMS_VENDOR);
		var concreteVendorObject1 = MessageFactory.createVendor(VendorType.SMS_VENDOR);
	 	concreteVendorObject1.sendMessage();
	 	
	 	Vendor concreteVendorObject2 = MessageFactory.createVendor(VendorType.EMAIL_VENDOR);
	 	concreteVendorObject2.sendMessage();
	}

}
