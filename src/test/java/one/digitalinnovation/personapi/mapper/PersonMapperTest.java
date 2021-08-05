package one.digitalinnovation.personapi.mapper;


import one.digitalinnovation.personapi.model.Person;
import one.digitalinnovation.personapi.model.Phone;
import one.digitalinnovation.personapi.model.dto.PersonDTO;
import one.digitalinnovation.personapi.model.dto.PhoneDTO;
import one.digitalinnovation.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonMapperTest {


    private PersonMapper mapper = PersonMapper.INSTANCE;

    //Comparation PersonDTO With Person
    @Test
    void testGivenPersonDToToReturnPersonModel() {

        PersonDTO personDTO = PersonUtils.createFakerDTO();

        Person person = mapper.toModel(personDTO);

        Assertions.assertEquals(personDTO.getFirstName(), person.getFirstName());
        Assertions.assertEquals(personDTO.getLastName(), person.getLastName());
        Assertions.assertEquals(personDTO.getCpf(), person.getCpf());

        Phone phone = person.getPhones().get(0);

        PhoneDTO phoneDTO = personDTO.getPhones().get(0);

        Assertions.assertEquals(phoneDTO.getPhoneType(), phone.getPhoneType());
        Assertions.assertEquals(phoneDTO.getNumber(), phone.getNumber());

    }

    //Comparation Person with PersonDTO
    @Test
    void testGivenPersonModelToReturnPersonDTO() {

        Person person = PersonUtils.createFakeEntity();

        PersonDTO personDTO = mapper.personToDTO(person);

        Assertions.assertEquals(person.getFirstName(), personDTO.getFirstName());
        Assertions.assertEquals(person.getLastName(), personDTO.getLastName());
        Assertions.assertEquals(person.getCpf(), personDTO.getCpf());

        Phone phone = person.getPhones().get(0);

        PhoneDTO phoneDTO = personDTO.getPhones().get(0);

        Assertions.assertEquals(phone.getPhoneType(), phoneDTO.getPhoneType());
        Assertions.assertEquals(phone.getNumber(), phoneDTO.getNumber());

    }

}
