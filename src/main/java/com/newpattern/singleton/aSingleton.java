package com.newpattern.singleton;

import java.io.IOException;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class aSingleton implements Cloneable, Serializable {

	// Eager
//	private static final aSingleton SINGLETON_OBJECT = new aSingleton();
//	
//	public static aSingleton getASingleton() {
//		return SINGLETON_OBJECT;
//	}
	
	// Lazy
//	public static aSingleton SINGLETON_OBJECT;
//	static	{
//		SINGLETON_OBJECT = new aSingleton();
//	}
	
	// Private Ctor
	private aSingleton() {
		
	}
	
	private static aSingleton SINGLETON_OBJECT = null;

	static Logger logger = LoggerFactory.getLogger(aSingleton.class);
	
	// also lazy initialization : created on invoking getInstance()
	public static aSingleton getInstance() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (null == SINGLETON_OBJECT) {
			logger.info("{} , singleton object inside first null check", Thread.currentThread().getName());
			synchronized (aSingleton.class) {
				if (null == SINGLETON_OBJECT) {
					logger.info("SINGLETON_OBJECT created by {} ", Thread.currentThread().getName());
					SINGLETON_OBJECT = new aSingleton();
				}
			}// end synch
		}
		return SINGLETON_OBJECT;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// throw new CloneNotSupportedException();
		return SINGLETON_OBJECT;
	}
	
	protected Object readResolve() throws IOException {
		return SINGLETON_OBJECT;
	}
	
	
}
