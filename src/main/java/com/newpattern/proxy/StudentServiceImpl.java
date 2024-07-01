package com.newpattern.proxy;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentServiceImpl implements IStudentService {

	private static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	Map<String, Integer> studentRepo = new HashMap<>();
	
	public StudentServiceImpl() {
		studentRepo.put("Anirudh",101);
		studentRepo.put("Manu",102);
		studentRepo.put("Shilpi",105);
	}
	
	@Override
	public Integer getStudentIdByName(String name) {
		logger.info("Returning StduentId for name {}", name);
		return studentRepo.get(name);
	}

}
