package one.digitalinnovation.personapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Phone {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    private String number;
}
