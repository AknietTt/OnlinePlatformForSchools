package com.example.Subject.model.Users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specialization",schema = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @NotEmpty
    private String name;

    @ManyToMany(mappedBy = "specializations")
    private Set<Teacher> teachers = new HashSet<>();
}
