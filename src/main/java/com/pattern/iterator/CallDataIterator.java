package com.pattern.iterator;

public class CallDataIterator implements MyIterator {
	
	private CallData[] callDataList;
	private int pos = 0;
	
	// Constructor takes the array of callDataList
    // to iterate over.
	public CallDataIterator(CallData[] callList) {
		this.callDataList = callList;
	}
		
	@Override
	public boolean hasNext() {
		if (callDataList[pos] == null || pos > callDataList.length)
			return false;
		else
			return true;
	}
	
	@Override
	public Object next() {
		// 	return element and increment position
		return callDataList[pos++];
	}

}
