package com.pattern.iterator;

public class CallDataClientApplication {

	public void printCallDataCollection(CallDataCollection callCollections) {
		var iterator = callCollections.getIterator();
		while (iterator.hasNext()) {
			var call = (CallData) iterator.next();
			System.out.println(call.getDialogId() + " : " + call.getCallState());
		}
	}

	public static void main(String[] args) {
		CallDataClientApplication clientApplication = new CallDataClientApplication();

		CallDataCollection callCollection1 = new CallDataCollection();
		callCollection1.addCallData("1", "PRE");
		callCollection1.addCallData("2", "POST");
		callCollection1.addCallData("3", "END");

		clientApplication.printCallDataCollection(callCollection1);
		
		
		CallDataCollection callCollection2 = new CallDataCollection();
		callCollection2.addCallData("111", "PREEEE");
		callCollection2.addCallData("222", "POSTTT");
		callCollection2.addCallData("333", "ENDDDD");

		clientApplication.printCallDataCollection(callCollection2);
	}

}
