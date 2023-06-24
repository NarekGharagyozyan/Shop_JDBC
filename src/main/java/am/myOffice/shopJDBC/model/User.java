package am.myOffice.shopJDBC.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private Long id;
    private String name;
    private String lastname;
    private double balance;
    private String email;
    private String password;
    private int age;

}