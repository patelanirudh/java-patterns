package com.newpattern.chainofresp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.newpattern.chainofresp.CallRequest.CallRequestType;

public class QueryDeptHandler implements ICallRequestHandler {
	
	private static Logger logger = LoggerFactory.getLogger(QueryDeptHandler.class);
	
	@Override
	public boolean canHandleRequest(CallRequest request) {
		return request.getCallReqType() == CallRequestType.QUERY;
	}
	
	@Override
	public int getPriority() {
		return 1;
	}
	
	@Override
	public void handle(CallRequest request) {
		request.markHandled();
		logger.info("{}  : is being handled by {}", request, name());
	}
	
	@Override
	public String name() {
		return "QUERY_DEPT_HANDLER";
	}

}
