package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.model.Person;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")

public class PersonController {

    @Autowired
    private PersonService service;

    @PutMapping
    public Person createPerson(@RequestBody Person person){
        return service.createPerson(person);
    }

}
