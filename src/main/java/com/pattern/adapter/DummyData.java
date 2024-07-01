package com.pattern.adapter;

public class DummyData {
	String name;
	Integer requestId;

	public DummyData(String name, Integer requestId) {
		super();
		this.name = name;
		this.requestId = requestId;
	}
	
	public String getName() {
		return name;
	}
	public Integer getRequestId() {
		return requestId;
	}
}
