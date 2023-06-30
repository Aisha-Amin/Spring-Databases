package spring.database.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import spring.database.databasedemo.Entity.Person;
import spring.database.databasedemo.Jpa.PersonJpaRepo;

import java.util.Date;

//@SpringBootApplication
public class DatabaseJpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJpaRepo personJpaRepo;
	public static void main(String[] args) {
		SpringApplication.run(DatabaseJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {} ",personJpaRepo.findAll());
		logger.info("User id 10001 -> {}", personJpaRepo.findById(10001));
		logger.info("Users with name Aisha -> {}", personJpaRepo.findByName("Aisha"));
		personJpaRepo.deleteById(10004);
		logger.info("Inserting -> {}" ,
				personJpaRepo.insert(new Person("Amin","Karachi",new Date())));
		logger.info("Updating 10002 -> {}" ,
				personJpaRepo.update(new Person(10002,"Hashmi","Karachi",new Date())));
	}
}
