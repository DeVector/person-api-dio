package one.digitalinnovation.personapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PersonDTO {

    private long id;

    private String firstName;

    private String lastName;

    private List<PhoneDTO> phones;
    
}
