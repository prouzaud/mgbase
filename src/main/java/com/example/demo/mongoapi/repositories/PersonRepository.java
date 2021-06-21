package com.example.demo.mongoapi.repositories;

import com.example.demo.mongoapi.model.person.Person;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class PersonRepository {

    private final static String PERSON_COLLECTION_NAME = "persons";

    private MongoTemplate mongoTemplate;

    public PersonRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Person findByPersonId(String personId) {
        return mongoTemplate.findOne(
                new Query(where("personId").is(personId)),
                Person.class,
                PERSON_COLLECTION_NAME);
    }

    public Person insert(Person person) {
        return mongoTemplate.insert(person, PERSON_COLLECTION_NAME);
    }

    public Person save(Person person) {return mongoTemplate.save(person); }

    public void remove(Person person) { mongoTemplate.remove(person);}
    public void removeWhen(Person person) {
        mongoTemplate.remove(
                new Query(where("personId").is(personId).and("active").exists(false).orOperator(new Criteria("personId").ne(1))),
                PERSON_COLLECTION_NAME  //or @Document class
        );}


    public List<Person> findBy2(String personId) {
        return mongoTemplate.find(
                new Query(where("personId").is(personId).and("active").exists(false).orOperator(new Criteria("personId").ne(1))),
                Person.class,
                PERSON_COLLECTION_NAME);
    }
}
