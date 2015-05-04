package kr.co.bluezine;

import kr.co.bluezine.service.TestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
    public static void main(String[] args) {
    	logger.debug("-------------> Application Starting...");
        SpringApplication.run(Application.class, args);
        logger.debug("-------------> Success!");
    }
	
	@Autowired
	@Qualifier("TestServiceImpl")
	private TestService testService;

	@Override
	public void run(String... args) throws Exception {
		testService.insertUser("가나", "뱌뱌");
		String result = testService.getUser("가나");
		logger.debug(result);
	}
	
	
}
