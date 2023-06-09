package com.example.Subject.model.Users;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "parent", schema = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @NotEmpty
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty
    private String lastName;

    @Column(name = "phone")
    @Size(min = 3,max = 20)
    @NotEmpty
    private String phone;

    @Column(name = "email")
    @Email
    @NotEmpty
    private String email;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Student> students;


}
