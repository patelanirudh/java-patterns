package com.newpattern.chainofresp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.newpattern.chainofresp.CallRequest.CallRequestType;

public class LoanCardDeptHandler implements ICallRequestHandler {
	
	private static Logger logger = LoggerFactory.getLogger(LoanCardDeptHandler.class);
	
	@Override
	public boolean canHandleRequest(CallRequest request) {
		return request.getCallReqType() == CallRequestType.LOAN_CARD;
	}
	
	@Override
	public int getPriority() {
		return 2;
	}
	
	@Override
	public void handle(CallRequest request) {
		request.markHandled();
		logger.info("{}  : is being handled by {}", request, name());
	}
	
	@Override
	public String name() {
		return "LOAN_CARD_DEPT_HANDLER";
	}

}
