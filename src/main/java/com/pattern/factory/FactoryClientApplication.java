package com.pattern.factory;

public class FactoryClientApplication {
	
	private Vendor vendorObject = null;
	
	public Vendor getConcreteVendor() {
		return vendorObject;
	}
	
	public void buildVendor(VendorType vType) {
		vendorObject = MessageFactory.createVendor(vType);
	}
	
	public static void main(String[] args) {
		// Vendor concreteVendorObject = MessageFactory.createVendor(VendorType.SMS_VENDOR);
		// Client directly working on concrete vendor 
		var concreteVendorObject1 = MessageFactory.createVendor(VendorType.SMS_VENDOR);
	 	concreteVendorObject1.sendMessage();
	 	
	 	// Each Client object is having its own concrete vendor state
	 	FactoryClientApplication clientObject1 = new FactoryClientApplication();
	 	clientObject1.buildVendor(VendorType.EMAIL_VENDOR);
	 	clientObject1.getConcreteVendor().sendMessage();		
	}
}
