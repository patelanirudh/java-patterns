package com.newpattern.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaytmStrategy implements IPaymentStrategy {

private static Logger logger = LoggerFactory.getLogger(PaytmStrategy.class);
	
	public PaytmStrategy() {
		logger.info("Paytm payment strategy intialized");
	}

	@Override
	public boolean pay(Double amount) {
		logger.info("Paytm Payment in process ...");
		logger.info("Paytm Payment failed ...");
		return false;
	}
}
