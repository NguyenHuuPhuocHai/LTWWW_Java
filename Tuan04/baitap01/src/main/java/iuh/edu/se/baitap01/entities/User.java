package iuh.edu.se.baitap01.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthday;
    private String gender;
}
