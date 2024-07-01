package com.pattern.builder;

public class Foo {

	private String name;
	private Integer empNo;
	private int branchId;
	private Address address;

	public Foo(FooBuilder builder) {
		this.name = builder.getName();
		this.empNo = builder.getEmpNo();
		this.branchId = builder.getBranchId();
		this.address = builder.getAddress();
	}

	public static FooBuilder createBuilder() {
		return new FooBuilder();
	}
	
	public static AddressBuilder createAddressBuilder() {
		return new AddressBuilder();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name ").append(this.name).append(" ").append("empNo ").append(this.empNo).append(" ")
		.append("branchId ").append(this.branchId).append(" ").append("address ").append("[").append(this.address).append("]");
		
		return sb.toString();
	}
}

class Address {
	private String city;
	private String state;
	private long pincode;
	
	public Address(AddressBuilder addressBuilder) {
		this.city = addressBuilder.getCity();
		this.state = addressBuilder.getState();
		this.pincode = addressBuilder.getPincode();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("city ").append(this.city).append(" ").append("state ").append(this.state)
		.append(" ").append("pincode ").append(this.pincode);
		
		return sb.toString();
	}
}
