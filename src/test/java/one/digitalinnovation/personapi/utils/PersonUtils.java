package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.model.Person;
import one.digitalinnovation.personapi.model.dto.PersonDTO;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRS_NAME = "Victor";
    private static final String LAST_NAME = "Diniz";
    private static final String CPF_NUMBER = "000.000.000-01";
    private static final long PERSON_ID = 1L;
    private static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 21);

    public static PersonDTO createFakerDTO(){
        return PersonDTO.builder()
                .firstName(FIRS_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("21-10-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakePhoneDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRS_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakePhoneEntity()))
                .build();
    }
}
