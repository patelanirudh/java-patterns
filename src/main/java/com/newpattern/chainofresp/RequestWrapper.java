package com.newpattern.chainofresp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.newpattern.chainofresp.CallRequest.CallRequestType;

public class RequestWrapper {

	private static Logger logger = LoggerFactory.getLogger(RequestWrapper.class);
	
	List<ICallRequestHandler> callRequestHandlers;
	
	public RequestWrapper() {
		buildHandlerChain();
	}
	
	void buildHandlerChain() {
		callRequestHandlers = Arrays.asList(new QueryDeptHandler(), new LoanCardDeptHandler(), 
				new BillingDeptHandler(), new ProductServicesDeptHandler());
	}
	
	void makeRequest(CallRequest callRequest) {
		Optional<ICallRequestHandler> requestHandler = callRequestHandlers.stream()
																	.sorted(Comparator.comparing(ICallRequestHandler::getPriority))
																	// this is where passing of deptHandlers is happening
																	.filter(deptHandler -> deptHandler.canHandleRequest(callRequest))
																	.findFirst();
		
		requestHandler.ifPresentOrElse(deptHandler -> deptHandler.handle(callRequest),
				() -> logger.info("Your call request cannot be handled ryt now"));
	}
	
	public static void main(String[] args) {
		// Assume this being done in a client class
		RequestWrapper reqWrapper = new RequestWrapper();
		
		reqWrapper.makeRequest(new CallRequest("this is a product services call", CallRequestType.PRODUCTS_SERVICES));
		reqWrapper.makeRequest(new CallRequest("this is a loan and card dept call", CallRequestType.LOAN_CARD));
		reqWrapper.makeRequest(new CallRequest("this is a query dept call", CallRequestType.QUERY));
		reqWrapper.makeRequest(new CallRequest("this is a billing dept call", CallRequestType.BILLING));
	}
}
