package com.example.demo.mongoapi.repositories;

import com.example.demo.mongoapi.model.person.Person;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

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
}
