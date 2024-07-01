package com.newpattern.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentContext {
	
	private static Logger logger = LoggerFactory.getLogger(PaymentContext.class);
	
	enum PaymentType {
		UPI,
		Paytm,
		GPay,
	}
	
	private IPaymentStrategy paymentStrategy;
	
	public void setPaymentStrategy(PaymentType pType) {
		switch (pType) {
		case UPI: 
			paymentStrategy = new UPIStrategy();
			break;
		case Paytm:
			paymentStrategy = new PaytmStrategy();
			break;
		default:
			logger.info("No such payment strategy is available, Please opt from available choices !!!");
		}
	}
	
	public void changePaymentStrategy(PaymentType pType) {
		setPaymentStrategy(pType);
	}

	boolean executePayment(Double amount) {
		return paymentStrategy.pay(amount);
	}
}
