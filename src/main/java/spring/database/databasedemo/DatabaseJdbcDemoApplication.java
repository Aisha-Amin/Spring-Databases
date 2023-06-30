package spring.database.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import spring.database.databasedemo.Entity.Person;
import spring.database.databasedemo.jdbc.PersonDaoJdbc;

import java.util.Date;

//@SpringBootApplication
public class DatabaseJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonDaoJdbc personDaoJdbc;
	public static void main(String[] args) {
		SpringApplication.run(DatabaseJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {} ",personDaoJdbc.findAll());
		logger.info("User id 10001 -> {}", personDaoJdbc.findById(10001));
		logger.info("Users with name Aisha -> {}", personDaoJdbc.findByName("Aisha"));
		logger.info("Deleting 10004 -> No of rows deleted -> {}",personDaoJdbc.deleteById(10004));
		logger.info("Inserting 10005 -> {}" ,
				personDaoJdbc.insert(new Person(10005,"Amin","Karachi",new Date())));
		logger.info("Updating 10002 -> {}" ,
				personDaoJdbc.update(new Person(10002,"Hashmi","Karachi",new Date())));
		logger.info("User id 10002 -> {}", personDaoJdbc.findById(10002));
	}
}
