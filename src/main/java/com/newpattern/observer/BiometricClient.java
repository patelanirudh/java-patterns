package com.newpattern.observer;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BiometricClient {

	private static Logger logger = LoggerFactory.getLogger(BiometricClient.class);
	
	public static void main(String[] args) {
		StandardAssertionObserver stObserver1 = new StandardAssertionObserver();
		StandardAssertionObserver stObserver2 = new StandardAssertionObserver();
		
		HiFidelityAssertionObserver hifiObserver1 = new HiFidelityAssertionObserver();
		HiFidelityAssertionObserver hifiObserver2 = new HiFidelityAssertionObserver();
		
		BiometricAssertionCollector assertionCollector = new BiometricAssertionCollector();
		assertionCollector.registerObservers(Arrays.asList(stObserver1, stObserver2, hifiObserver1, hifiObserver2));
		
		logger.info("Count of registered observers " + assertionCollector.getObserversCount());
		
		StandardAssertionData stData1 = new StandardAssertionData("101", "12345", "PASSED", true);
		StandardAssertionData stData2 = new StandardAssertionData("102", "67890", "FAILED", false);
		HifidelityAssertionData hifiData1 = new HifidelityAssertionData("501", "555", "92721", "FACIAL_PASSED", true);
		HifidelityAssertionData hifiData2 = new HifidelityAssertionData("601", "666", "99232", "FACIAL_FAILED", false);
		
		assertionCollector.setStandardAssertion(stData2);
		assertionCollector.setHifissertion(hifiData2);
		
		assertionCollector.deregisterObservers(stObserver2);
		assertionCollector.deregisterObservers(hifiObserver2);
		
		logger.info("Count of registered observers " + assertionCollector.getObserversCount());
		
		assertionCollector.setStandardAssertion(stData1);
		assertionCollector.setHifissertion(hifiData1);
		
		assertionCollector.deregisterAllObservers();
		logger.info("Count of registered observers " + assertionCollector.getObserversCount());
	}
}
