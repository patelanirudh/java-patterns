package com.pattern.adapter;

public class Client {
	
	ModernMessage moderMessageSender;
	
	public Client(ModernMessage actualMsgSender) {
		moderMessageSender = actualMsgSender;
	}
	
	void wishToSendSMS() {
		System.out.println("Client is wishing to send SMS");
		moderMessageSender.sendSMS();
	}
	
	public static void main(String[] args) {
		Client object = new Client(new ZangSMSSender());
		object.wishToSendSMS(); // new ZangSMSSender()
		
		Client object1 = new Client(new ModernToLegacyAdapter());
		object1.wishToSendSMS(); // new ModernToLegacyAdapter()
	}

}
