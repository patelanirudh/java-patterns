package com.newpattern.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HiFidelityAssertionObserver implements AssertionObservers {
	
	private static Logger logger = LoggerFactory.getLogger(HiFidelityAssertionObserver.class);
	
	@Override
	public void updateHifidelityAssertionStatus(HifidelityAssertionData hifidelityAssertionData) {
		logger.info("Received hifiAssertion Data \n {}", hifidelityAssertionData);
	}
}
