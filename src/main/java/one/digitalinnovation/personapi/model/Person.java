package one.digitalinnovation.personapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data

@AllArgsConstructor
@NoArgsConstructor

@Builder

@Entity

public class Person {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;

    private String lastName;

    private String cpf;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Phone> phone;

}
