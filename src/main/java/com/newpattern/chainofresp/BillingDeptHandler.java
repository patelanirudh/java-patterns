package com.newpattern.chainofresp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.newpattern.chainofresp.CallRequest.CallRequestType;

public class BillingDeptHandler implements ICallRequestHandler {
	
	private static Logger logger = LoggerFactory.getLogger(BillingDeptHandler.class);
	
	@Override
	public boolean canHandleRequest(CallRequest request) {
		return request.getCallReqType() == CallRequestType.BILLING;
	}
	
	@Override
	public int getPriority() {
		return 3;
	}
	
	@Override
	public void handle(CallRequest request) {
		request.markHandled();
		logger.info("{}  : is being handled by {}", request, name());
	}
	
	@Override
	public String name() {
		return "BILLING_DEPT_HANDLER";
	}

}
