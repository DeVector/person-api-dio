package one.digitalinnovation.personapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder

public class PhoneDTO {

    private long id;

    private PhoneType phoneType;

    private String number;
}
