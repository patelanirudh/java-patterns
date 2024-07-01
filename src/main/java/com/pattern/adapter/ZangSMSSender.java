package com.pattern.adapter;

public class ZangSMSSender implements ModernMessage {
	
	@Override
	public void sendSMS() {
		System.out.println("ZangSMSSender is modern and sending message via HTTP way");
	}
}
