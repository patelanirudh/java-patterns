package com.newpattern.singleton;

import java.io.IOException;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class nSingleton implements Cloneable, Serializable {
//	Eager initialization
//	private static final nSingleton INSTANCE = new nSingleton();
//	public static nSingleton getInstance() {
//		return INSTANCE;
//	}
	
//	lazy initialization : access public object directly
//	public static nSingleton INSTANCE;
//	static {
//		INSTANCE = new nSingleton();
//	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static Logger logger = LoggerFactory.getLogger(nSingleton.class);
	
	private static nSingleton INSTANCE = null;
	
	private nSingleton() {
		
	}
	
	public static nSingleton getSingletonInstance() throws InterruptedException {
		Thread.sleep(10);
		if (null == INSTANCE) {
			synchronized(nSingleton.class) { // class level lock
				if (null == INSTANCE) { // double null check
					logger.info(Thread.currentThread().getName() + " created the singleton instance");
					INSTANCE = new nSingleton();
				}
			} // end synchronized
		}
		return INSTANCE;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// throw new CloneNotSupportedException();
		return INSTANCE;
	}
	
	// implement readResolve method and prevent serialization of Singleton
	// Object by returning the same instance
	protected Object readResolve() throws IOException {
		// throw new IOException("Cannot do so");
		return INSTANCE;
	}
}
