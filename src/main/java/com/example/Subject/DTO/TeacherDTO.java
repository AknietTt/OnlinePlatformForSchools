package com.example.Subject.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;
}
