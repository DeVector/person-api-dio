package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.enums.PhoneType;
import one.digitalinnovation.personapi.model.Phone;
import one.digitalinnovation.personapi.model.dto.PhoneDTO;

public class PhoneUtils {

    private static final long ID_PHONE = 1L;
    private static final String NUMBER_PHONE = "+55 (83) 9898-0000";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;

    public static PhoneDTO createFakePhoneDTO() {
        return PhoneDTO.builder()
                .number(NUMBER_PHONE)
                .phoneType(PHONE_TYPE)
                .build();
    }

    public static Phone createFakePhoneEntity() {
        return Phone.builder()
                .id(ID_PHONE)
                .number(NUMBER_PHONE)
                .phoneType(PHONE_TYPE)
                .build();
    }

}
