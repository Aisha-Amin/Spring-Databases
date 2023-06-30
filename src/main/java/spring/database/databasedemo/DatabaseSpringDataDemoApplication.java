package spring.database.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.database.databasedemo.Entity.Person;
import spring.database.databasedemo.SpringData.PersonSpringDataRepository;

import java.util.Date;

@SpringBootApplication
public class DatabaseSpringDataDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonSpringDataRepository personSpringDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseSpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {} ",personSpringDataRepository.findAll());
		logger.info("User id 10001 -> {}", personSpringDataRepository.findById(10001));
		logger.info("Users with name Aisha -> {}", personSpringDataRepository.findByName("Aisha"));
		personSpringDataRepository.deleteById(10004);
		logger.info("Inserting -> {}" ,
				personSpringDataRepository.save(new Person("Amin","Karachi",new Date())));
		logger.info("Updating 10002 -> {}" ,
				personSpringDataRepository.save(new Person(10002,"Hashmi","Karachi",new Date())));
	}
}
