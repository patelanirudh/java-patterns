package com.newpattern.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentServiceProxy implements IStudentService {

	private static Logger logger = LoggerFactory.getLogger(StudentServiceProxy.class);
			
	private static IStudentService studentService;
	
	private void initializeConcreteObject() {
		if (studentService == null) {
			logger.info("Inside StudentServiceProxy : creating and initializing concrete StudentServiceImpl");
			studentService = new StudentServiceImpl();
		}
	}
	
	@Override
	public Integer getStudentIdByName(String name) {
		// always the first line in all methods or maybe a boolean check
		// to verify if concrete object has already been created
		initializeConcreteObject();  
		return	studentService.getStudentIdByName(name);
	}
}
