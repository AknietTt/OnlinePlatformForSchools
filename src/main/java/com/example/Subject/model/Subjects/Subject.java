package com.example.Subject.model.Subjects;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "subject",schema = "Subjects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @NotEmpty
    @Size(min = 3,max = 30)
    private String nameRu;

    @Column(name = "description_ru")
    private String descriptionRu;
}
