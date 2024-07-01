package com.newpattern.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.newpattern.strategy.PaymentContext.PaymentType;

public class PaymentClient {
	
	private static Logger logger = LoggerFactory.getLogger(PaymentClient.class);
	
	public static void main(String[] args) {
		PaymentContext pCtx = new PaymentContext();
		pCtx.setPaymentStrategy(PaymentType.Paytm);
		boolean paymentStatus = pCtx.executePayment(Double.valueOf(1000.00));
		if (!paymentStatus) {
			logger.info("Earlier payment failed. Changing payment strategy");
			pCtx.changePaymentStrategy(PaymentType.UPI);
			paymentStatus = pCtx.executePayment(Double.valueOf(1000.00));
			if (paymentStatus) {
				logger.info("Payment was successful");
			}
		}
	}
}
