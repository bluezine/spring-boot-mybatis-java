package kr.co.bluezine;

import java.util.ArrayList;
import java.util.List;

import kr.co.bluezine.dao.User;
import kr.co.bluezine.service.TestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
    public static void main(String[] args) {
    	logger.debug("-------------> Application Starting...");
        SpringApplication.run(Application.class, args);
        logger.debug("-------------> End Application");
    }
	
	@Autowired
	@Qualifier("TestServiceImpl")
	private TestService testService;

	@Override
	public void run(String... args) throws Exception {
		List<User> users = new ArrayList<User>();
		users = testService.getUsers();
		logger.debug("============Initial Data============");
		logger.debug("    ID          |           NAME");
		for (User u : users) {
			logger.debug("   " + u.getId() + "        |         " + u.getName());
		}
		logger.debug("====================================");
		User user = new User();
		user.setId("test4");
		user.setName("test4");
		logger.debug("============> Add User test4/test4");
		testService.insertUser(user);
		users = testService.getUsers();
		logger.debug("============Current Data============");
		logger.debug("    ID          |           NAME");
		for (User u : users) {
			logger.debug("   " + u.getId() + "        |         " + u.getName());
		}
		logger.debug("====================================");
		logger.debug("============> Del User test1/test1");
		testService.deleteUser("test1");
		users = testService.getUsers();
		logger.debug("============Current Data============");
		logger.debug("    ID          |           NAME");
		for (User u : users) {
			logger.debug("   " + u.getId() + "        |         " + u.getName());
		}
		logger.debug("====================================");
		return;
	}
	
	
}
