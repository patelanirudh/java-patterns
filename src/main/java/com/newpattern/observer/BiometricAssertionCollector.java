package com.newpattern.observer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BiometricAssertionCollector implements BiometricAssertion {

	private static Logger logger = LoggerFactory.getLogger(BiometricAssertionCollector.class);
	
	public int getObserversCount() {
		return assertionObservers.size();
	}
	
	@Override
	public void registerObservers(AssertionObservers observers) {
		assertionObservers.add(observers);
	}
	
	@Override
	public void registerObservers(List<AssertionObservers> observers) {
		logger.info("Registering {} observers", observers.size());
		assertionObservers.addAll(observers);
	}
	
	@Override
	public void deregisterObservers(AssertionObservers observers) {
		logger.info("Deregistering an observer", observers);
		assertionObservers.remove(observers);
	}
	
	@Override
	public void deregisterAllObservers() {
		logger.info("Deregistering all observers");
		assertionObservers.clear();
	}

	@Override
	public void setStandardAssertion(StandardAssertionData standardAssertionData) {
		logger.info("Setting StandardAssertion ...");
		notifyStandardObservers(standardAssertionData);
	}

	@Override
	public void setHifissertion(HifidelityAssertionData hifiAssertionData) {
		logger.info("Setting HifidelityAssertion ...");
		notifyHiFidelityObservers(hifiAssertionData);
	}

	@Override
	public void notifyStandardObservers(StandardAssertionData  standardAssertionData) {
		for (AssertionObservers observer : assertionObservers) {
			if (observer instanceof StandardAssertionObserver) {
				logger.info("Notifying StandardAssertion ... to ... {}", observer.toString());
				observer.updateStandardAssertionStatus(standardAssertionData);
			}
		}
	}

	@Override
	public void notifyHiFidelityObservers(HifidelityAssertionData hifidelityAssertionData) {
		for (AssertionObservers observer : assertionObservers) {
			if (observer instanceof HiFidelityAssertionObserver) {
				logger.info("Notifying HifidelityAssertion ... to ... {}", observer.toString());
				observer.updateHifidelityAssertionStatus(hifidelityAssertionData);
			}
		}
	}
}
