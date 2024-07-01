package com.pattern.adapter;

// Bridging the gap b/w to unrelated incompatible interfaces 
// ModernMessage vs LegacySMSSender(this could have been an interface as well)
public class ModernToLegacyAdapter implements ModernMessage {
		// Adaptee : composition
		LegacySMSSender legacySMSSender;
	
		public ModernToLegacyAdapter() {
			System.out.println("ModernToLegacyAdapter : Initializing legacy sms sender...");
			legacySMSSender = new LegacySMSSender();
		}
		
		@Override
		public void sendSMS() {
			System.out.println("ModernToLegacyAdapter invoking LegacySMSSender to send SMS");
			legacySMSSender.oldWayToSendSMS();
		}
}
