package one.digitalinnovation.personapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder

public class PhoneDTO {

    private long id;

    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    @NotEmpty
    @Size(min = 12, max = 19)
    private String number;
}
