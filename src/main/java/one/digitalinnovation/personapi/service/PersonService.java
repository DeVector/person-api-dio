package one.digitalinnovation.personapi.service;


import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.model.Person;
import one.digitalinnovation.personapi.model.dto.PersonDTO;
import one.digitalinnovation.personapi.model.response.MessageResponseDTO;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;


    private PersonMapper mapper = PersonMapper.INSTANCE;

    @Transactional
    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personSave = mapper.toModel(personDTO);

        Person personSaved = repository.save(personSave);

        return createMessageDTO(personSaved.getId(),"Person created with sucess id: ");

    }

    @Transactional
    public List<PersonDTO> findAll(){
        List<Person> allPeople = repository.findAll();
        return allPeople.stream()
                .map(mapper::personToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return mapper.personToDTO(person);
    }

    public void deleteById(Long id) throws PersonNotFoundException{

        Person person = verifyIfExists(id);

        repository.deleteById(person.getId());

    }

    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException{
        verifyIfExists(id);

        Person personUpdate = mapper.toModel(personDTO);

        Person personUpdated = repository.save(personUpdate);

        return createMessageDTO(personUpdated.getId(), "Update person with id: ");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException{
        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageDTO(Long id, String message){
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}
