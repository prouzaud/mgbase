package com.example.demo.mongoapi.business;

import com.example.demo.mongoapi.model.person.Person;
import com.example.demo.mongoapi.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findByPersonId(String personId) {
        return personRepository.findByPersonId(personId);
    }

    public Person insert(Person person) {
        return personRepository.insert(person);
    }
}
