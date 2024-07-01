package com.newpattern.chainofresp;

public class CallRequest {
	public enum CallRequestType {
		QUERY,
		BILLING,
		LOAN_CARD,
		PRODUCTS_SERVICES
	}
	
	private String callReqDescription;
	private CallRequestType callReqType;
	private boolean isHandled = false;
	
	public CallRequest(String callReqDescription, CallRequestType callReqType) {
		this.callReqDescription = callReqDescription;
		this.callReqType = callReqType;
	}
	
	public void markHandled() {
		isHandled = true;
	}
	
	public boolean isReqHandled() {
		return isHandled;
	}
	
	public String getCallReqDescription() {
		return callReqDescription;
	}
	
	public CallRequestType getCallReqType() {
		return callReqType;
	}

	@Override
	public String toString() {
		return "CallRequest [callReqDescription=" + callReqDescription + ", callReqType=" + callReqType + ", isHandled="
				+ isHandled + "]";
	}
}
