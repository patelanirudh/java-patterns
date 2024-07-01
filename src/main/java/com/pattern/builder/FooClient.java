package com.pattern.builder;

public class FooClient {
	
	public static void main(String[] args) {
		AddressBuilder addressBuilder = Foo.createAddressBuilder();
		Address empOneAddress = addressBuilder.city("jabalpur")
											//.state("madhya pradesh")
											.pincode(482020L)
											.build();

		FooBuilder fooBuilder = Foo.createBuilder();
		Foo empOneCreated = fooBuilder.name("anirudh")
									.empNo(101)
									//.branchId(135)
									.address(empOneAddress)
									.build();

		System.out.println("Employee created usig Builder Pattern \n" + empOneCreated.toString());
	}
}
