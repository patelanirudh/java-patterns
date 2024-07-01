package com.newpattern.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardAssertionObserver implements AssertionObservers {
	
	private static Logger logger = LoggerFactory.getLogger(StandardAssertionObserver.class);
	
	@Override
	public void updateStandardAssertionStatus(StandardAssertionData standardAssertionData) {
		logger.info("Received standardAssertion Data \n {}", standardAssertionData);
	}

}
