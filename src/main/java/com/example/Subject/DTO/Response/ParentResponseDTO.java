package com.example.Subject.DTO.Response;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParentResponseDTO {
    @NotNull
    @Positive
    private int id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Size(min = 3,max = 20)
    @NotEmpty
    private String phone;

    @Email
    @NotEmpty
    private String email;
}
