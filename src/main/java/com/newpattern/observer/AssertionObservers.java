package com.newpattern.observer;

public interface AssertionObservers {
	
	default void updateStandardAssertionStatus(StandardAssertionData standardAssertionData) {
		
	}
	
	default void updateHifidelityAssertionStatus(HifidelityAssertionData hifidelityAssertionData) {
		
	}
}
