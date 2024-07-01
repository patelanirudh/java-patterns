package com.newpattern.observer;

import java.util.ArrayList;
import java.util.List;

public interface BiometricAssertion {

	List<AssertionObservers> assertionObservers = new ArrayList<>();
		
	void registerObservers(AssertionObservers observers);
	void registerObservers(List<AssertionObservers> observers);
	void deregisterObservers(AssertionObservers observers);
	void deregisterAllObservers();
		
	void setStandardAssertion(StandardAssertionData standardAssertionData);
	void setHifissertion(HifidelityAssertionData hifiAssertionData);
	
	void notifyStandardObservers(StandardAssertionData standardAssertionData);
	void notifyHiFidelityObservers(HifidelityAssertionData hifidelityAssertionData);
}
