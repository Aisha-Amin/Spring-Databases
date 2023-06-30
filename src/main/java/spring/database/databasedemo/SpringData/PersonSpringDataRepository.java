package spring.database.databasedemo.SpringData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.database.databasedemo.Entity.Person;

import java.util.List;

@Repository
public interface PersonSpringDataRepository extends JpaRepository<Person,Integer> {
    List<Person> findByName(String aisha);
}
