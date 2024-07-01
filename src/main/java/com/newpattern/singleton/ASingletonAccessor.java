package com.newpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ASingletonAccessor {
	static Logger logger = LoggerFactory.getLogger(ASingletonAccessor.class);
	
	public static void main(String[] args) throws CloneNotSupportedException, InterruptedException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		// Reflection Access : Breaks Singleton
//		Constructor<?>[] declaredConstructors = aSingleton.class.getDeclaredConstructors();
//		for (Constructor<?> ctor : declaredConstructors) {
//			ctor.setAccessible(true);
//			aSingleton reflectInstance = (aSingleton)ctor.newInstance();
//			logger.info("singleton created by reflection {}", reflectInstance.hashCode());
//		}
		
		ExecutorService testExecutorService = Executors.newFixedThreadPool(5);
		
		for (int i=0; i<5; ++i) {
			testExecutorService.submit(() -> {
				aSingleton firstSingletonObject = aSingleton.getInstance();
				logger.info("{} singleton object {}", Thread.currentThread().getName(), firstSingletonObject.hashCode());
			});
		}
		
		testExecutorService.shutdown();
		Thread.sleep(100);
		
		aSingleton instance1 = aSingleton.getInstance(); 
		aSingleton instance2 = (aSingleton) instance1.clone();
		logger.info("instance1 : {}, instance2 : {}", instance1.hashCode(), instance2.hashCode());
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"))) {
			oos.writeObject(instance1);
			aSingleton deserializedObject = (aSingleton) ois.readObject();
			logger.info("Deserialized singleton instance {}", deserializedObject.hashCode());
		}
	}

}
