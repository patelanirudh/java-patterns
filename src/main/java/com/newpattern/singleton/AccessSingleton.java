package com.newpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessSingleton {
	
	static Logger logger = LoggerFactory.getLogger(AccessSingleton.class);
	
	public static void main(String[] args) throws InterruptedException, CloneNotSupportedException, IOException, ClassNotFoundException {
		ExecutorService exService = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 5; ++i) {
			exService.submit(() -> {
				try {
					nSingleton instanceObject = nSingleton.getSingletonInstance();
					logger.info(Thread.currentThread().getName() + ", got nSingleton instanceObject " + instanceObject.hashCode());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		
		exService.shutdown();
		if (!exService.awaitTermination(3, TimeUnit.SECONDS)) {
			exService.shutdownNow();
		}
		
		nSingleton instance1 = nSingleton.getSingletonInstance();
		nSingleton clonedInstance = (nSingleton)instance1.clone();
		logger.info("instance1 " + instance1.hashCode() + ", clonedInstance " + clonedInstance.hashCode());
		
		// serialization
		FileOutputStream fos = new FileOutputStream("b.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(clonedInstance);
		fos.close();
		oos.close();
		
		// de-serialization
		FileInputStream fis = new FileInputStream("b.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		nSingleton deserializedSingletonObject = (nSingleton) ois.readObject();
		logger.info("Deserialized singleton object " + deserializedSingletonObject.hashCode());
		
		fis.close();
		ois.close();
	}

}
