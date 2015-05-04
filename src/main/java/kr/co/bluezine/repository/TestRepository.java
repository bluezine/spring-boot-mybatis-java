package kr.co.bluezine.repository;

import kr.co.bluezine.mapper.TestMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("TestRepository")
public class TestRepository {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private TestMapper getMapper() {
		return sqlSessionTemplate.getMapper(TestMapper.class);
	}
	
	public String getUser(String id) {
		return getMapper().getUser(id);
	}
	
	public void insertUser(String id, String password) {
		getMapper().insertUser(id, password);
	}
}
