package spring.database.databasedemo.Jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import spring.database.databasedemo.Entity.Person;

import java.util.List;

@Repository
@Transactional
public class PersonJpaRepo {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id){
        return entityManager.find(Person.class,id);
    }

    public List<Person> findByName(String name){
        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p WHERE p.name = :name", Person.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Person> findAll(){
      TypedQuery<Person> namedQuery =  entityManager.createNamedQuery("find_all_persons", Person.class);
      return namedQuery.getResultList();
    }

    // merge for both insert and update
 // if there is id in person it updates it otherwise create new

    public Person insert(Person person){
        return entityManager.merge(person);
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
        Person person = findById(id);
        entityManager.remove(person);
    }
}
