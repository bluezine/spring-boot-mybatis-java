package kr.co.bluezine.service.impl;

import kr.co.bluezine.repository.TestRepository;
import kr.co.bluezine.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("TestServiceImpl")
public class TestServiceImpl implements TestService {
	
	@Autowired
	@Qualifier("TestRepository")
	private TestRepository testRepository;

	@Override
	public String getUser(String id) {
		return testRepository.getUser(id);
	}

	@Override
	public void insertUser(String id, String password) {
		testRepository.insertUser(id, password);
	}
}
