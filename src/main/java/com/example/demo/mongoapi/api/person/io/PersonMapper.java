package com.example.demo.mongoapi.api.person.io;

import com.example.demo.mongoapi.model.person.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonResponse toResponse(Person person) {
        return new PersonResponse(person.getPersonId(), person.getFirstName(), person.getLastName());
    }

    public Person fromRequest(PersonRequest personRequest) {
        return new Person(personRequest.getPersonId(), personRequest.getFirstName(), personRequest.getLastName(), true);
    }
}
