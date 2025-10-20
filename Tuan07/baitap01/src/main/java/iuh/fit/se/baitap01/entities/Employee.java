package iuh.fit.se.baitap01.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "First Name khong dduoc phep rong")
    private String firstName;

    @NotEmpty(message = "Last Name khong dduoc phep rong")
    private String lastName;
}
