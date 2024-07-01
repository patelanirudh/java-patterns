package com.pattern.singleton;

import java.io.IOException;
import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	
	/*
	 * Eager Initialization
	 * 	private static final Singleton instance = new Singleton()
	 *  public static Singleton getInstance() {  return instance; }
	 * 
	 * Static Block Initialization : remove getInstance() and make instance object public
	 * 	public static Singleton instance;
	 * static
	 * {
	 * 	 instance = new Singleton();
	 *   // can also handle exceptions
	 * }
	 */
	
	/**
	 * 
	 */
	
	//	public volatile static Singleton instance; // tell CPU not to optimize the null check on instance object
	private static Singleton instance;

	private Singleton() {
	}

	// static synchronized == Class Lock == synchronized(Singleton.class)
	public static synchronized Singleton getInstance1_syncblock() {
		System.out.println("getInstance1_syncblock accessed by thread : " + Thread.currentThread().getName());
		if (null == instance) {
			instance = new Singleton();
		}
		return instance;
	}

	public static Singleton getInstance2_doubleCheck() throws InterruptedException {
		Thread.sleep(10);
		// few threads will not pass this check and will directly return the instance
		if (null == instance) {
			synchronized (Singleton.class) {
				System.out.println("getInstance2_doubleCheck accessed by thread : " + Thread.currentThread().getName());
				if (null == instance) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	// this is to avoid cloning of Singleton object
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return instance;
		// OR throw new CloneNotSupportedException();
	}
	
	// implement readResolve method and prevent serialization of Singleton
	// Object by returning the same instance
	protected Object readResolve() {
		// throw new IOException("cannot do so"); 
		return instance;
	}
	
}
