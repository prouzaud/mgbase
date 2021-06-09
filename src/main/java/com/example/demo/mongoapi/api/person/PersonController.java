package com.example.demo.mongoapi.api.person;

import com.example.demo.mongoapi.api.person.io.PersonMapper;
import com.example.demo.mongoapi.api.person.io.PersonRequest;
import com.example.demo.mongoapi.api.person.io.PersonResponse;
import com.example.demo.mongoapi.api.person.io.PersonStatus;
import com.example.demo.mongoapi.business.PersonService;
import com.example.demo.mongoapi.model.person.Person;
import lombok.NonNull;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/1.0/mongoDemo/person")
public class PersonController {

    private PersonService personService;
    private PersonMapper personMapper;

    public PersonController(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    @GetMapping("/{personId}")
    public PersonResponse findPerson(@NonNull @PathVariable("personId") String personId) {
        Person person = personService.findByPersonId(personId);
        return personMapper.toResponse(person);
    }


    @PostMapping("/")
    public PersonStatus insert(@NonNull @RequestBody PersonRequest personRequest) {
        Person person = personMapper.fromRequest(personRequest);
        personService.insert(person);
        return new PersonStatus();
    }
}
