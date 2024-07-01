package com.newpattern.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UPIStrategy implements IPaymentStrategy {
	
	private static Logger logger = LoggerFactory.getLogger(UPIStrategy.class);
	
	public UPIStrategy() {
		logger.info("UPI payment strategy intialized");
	}
	
	@Override
	public boolean pay(Double amount) {
		logger.info("UPI Payment in process ...");
		logger.info("UPI Payment completed ...");
		return true;
	}

}
