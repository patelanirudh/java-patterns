package com.pattern.iterator;

public class CallDataCollection implements Collection {

	private static final int MAX_ITEMS = 10;
	private CallData[] callDataList; 
	private int numOfItems = 0;
	
	public CallDataCollection() {
		callDataList = new CallData[MAX_ITEMS];
	}
	
	public void addCallData(String id, String state) {
		if (numOfItems >= MAX_ITEMS) {
			System.err.println("CallDataList is FULL !!!");
		}
		
		CallData callData = new CallData(id, state);
		callDataList[numOfItems++] = callData;
	}
	
	@Override
	public MyIterator getIterator() {
		return new CallDataIterator(callDataList);
	}
}
