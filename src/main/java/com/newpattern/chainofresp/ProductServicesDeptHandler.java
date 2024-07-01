package com.newpattern.chainofresp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.newpattern.chainofresp.CallRequest.CallRequestType;

public class ProductServicesDeptHandler implements ICallRequestHandler {
	
	private static Logger logger = LoggerFactory.getLogger(ProductServicesDeptHandler.class);
	
	@Override
	public boolean canHandleRequest(CallRequest request) {
		return request.getCallReqType() == CallRequestType.PRODUCTS_SERVICES;
	}
	
	@Override
	public int getPriority() {
		return 4;
	}
	
	@Override
	public void handle(CallRequest request) {
		request.markHandled();
		logger.info("{}  : is being handled by {}", request, name());
	}
	
	@Override
	public String name() {
		return "PRODUCTS_SERVICES_DEPT_HANDLER";
	}

}
