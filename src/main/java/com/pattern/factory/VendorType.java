package com.pattern.factory;

public enum VendorType {

	SMS_VENDOR("SMS_VENDOR"),
	EMAIL_VENDOR("EMAIL_VENDOR");
	
	private String vendorType;
	
	private VendorType(String type) {
		this.vendorType = type;
	}
	
	public String getVendorType() {
		return vendorType;
	}
}
