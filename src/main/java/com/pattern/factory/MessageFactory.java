package com.pattern.factory;


// Class Message Factory with a single responsibility to
// construct Message Vendors according to the clients requests.

public abstract class MessageFactory {
	
	// Abstract class can have static/non-static methods
	public static Vendor createVendor(VendorType type) {
		if (VendorType.SMS_VENDOR.compareTo(type) == 0) {
			return new SMSVendor();
		} else if (VendorType.EMAIL_VENDOR.compareTo(type) == 0) {
			return new EmailVendor();
		} else {
			System.out.println("Incompatible vendor type " + type.getVendorType() +" has been supplied !!!!");
			return null;
		}
	}

	// Abstract class can have concrete methods(non-static) as well
	// Abstract class can have final/non-final/static/non-static fields as well
	// Abstract class can have public, protected and private access specifiers
}
