package one.digitalinnovation.personapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data

@AllArgsConstructor
@NoArgsConstructor

@Builder

@Entity

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private LocalDate birthDate;

    @Column(nullable = false, unique = true)
    private String cpf;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Phone> phones;

}
