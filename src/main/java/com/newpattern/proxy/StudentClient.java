package com.newpattern.proxy;

public class StudentClient {
	
	// autowiring/injecting a Proxy instance
	static StudentServiceProxy studentServiceProxy = null;
	
	public static void main(String[] args) {
		studentServiceProxy = new StudentServiceProxy();
		System.out.println("Received StudentId : " + studentServiceProxy.getStudentIdByName("Anirudh"));
	}
}
