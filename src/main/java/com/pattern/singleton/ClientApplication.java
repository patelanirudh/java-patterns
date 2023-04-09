package com.pattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientApplication {

	private static ExecutorService clientExecutor = Executors.newFixedThreadPool(5);

	public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
		// Run either of these codes and comment the one which is not needed

//		for (int i = 0; i < 2; ++i) {
//			clientExecutor.submit(() -> { // lambda expression
//				Singleton singletonObject = Singleton.getInstance1_syncblock();
//				System.out.println("Thread : " + Thread.currentThread().getName() + ", Singleton object hashCode = "
//						+ singletonObject.hashCode());
//			});
//		}
//
//		Thread.sleep(1000);

		System.out.println("================= Double check lock singleton ====================");
		for (int i = 0; i < 5; ++i) {
			clientExecutor.submit(new Runnable() { // anonymous inner class
				@Override
				public void run() {
					Singleton singletonObject = null;
					try {
						singletonObject = Singleton.getInstance2_doubleCheck();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Thread : " + Thread.currentThread().getName() + ", Singleton object hashCode = "
							+ singletonObject.hashCode());
				}
			});
		}
		
		clientExecutor.shutdown();
		
		Thread.sleep(600);
		System.out.println("================= Clone restricted singleton ====================");
		Singleton object1 = Singleton.getInstance1_syncblock();
		Singleton object2 = (Singleton) object1.clone();
		System.out.println("Object1 : " + object1.hashCode() + ", Object2 : " + object2.hashCode());
	}

}
