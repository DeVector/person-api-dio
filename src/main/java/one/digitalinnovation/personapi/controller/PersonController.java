package one.digitalinnovation.personapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.model.Person;
import one.digitalinnovation.personapi.model.dto.PersonDTO;
import one.digitalinnovation.personapi.model.response.MessageResponseDTO;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {


    private PersonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO){
        return service.createPerson(personDTO);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
        return service.update(id, personDTO);
    }

    @GetMapping
    public List<PersonDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException{
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException{
        service.deleteById(id);
    }

}
