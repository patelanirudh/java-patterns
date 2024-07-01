package com.newpattern.chainofresp;

public interface ICallRequestHandler {
	boolean canHandleRequest(CallRequest request);
	void handle(CallRequest request);
	int getPriority();
	String name();
}
