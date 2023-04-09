package com.pattern.iterator;

public class CallData {

	private String dialogId;
	private String callState;

	public CallData() {
		// Ctor chaining
		this(null);
	}

	public CallData(String id) {
		// Ctor chaining
		this(id, null);
	}

	public CallData(String id, String state) {
		this.dialogId = id;
		this.callState = state;
	}

	public String getDialogId() {
		return dialogId;
	}

	public String getCallState() {
		return callState;
	}
}
