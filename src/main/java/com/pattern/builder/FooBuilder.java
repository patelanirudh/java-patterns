package com.pattern.builder;

public class FooBuilder {
	private String name = null;
	private Integer empNo = null;
	private int branchId = 0;
	private Address address = null;	
	
	public FooBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public FooBuilder empNo(Integer empNo) {
		this.empNo = empNo;
		return this;
	}
	
	public FooBuilder branchId(int branchId) {
		this.branchId = branchId;
		return this;
	}
	
	public FooBuilder address(Address address) {
		this.address = address;
		return this;
	}

	// build
	public Foo build() {
		return new Foo(this);
	}

	public String getName() {
		return name;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public int getBranchId() {
		return branchId;
	}

	public Address getAddress() {
		return address;
	}
}

// Address Builder
class AddressBuilder {
	private String city = null;
	private String state = null;
	private long pincode = 0L;

	public AddressBuilder city(String city) {
		this.city = city;
		return this;
	}
	
	public AddressBuilder state(String state) {
		this.state = state;
		return this;
	}
	
	public AddressBuilder pincode(long pincode) {
		this.pincode = pincode;
		return this;
	}
	
	// build
	public Address build() {
		return new Address(this);
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public long getPincode() {
		return pincode;
	}
}
