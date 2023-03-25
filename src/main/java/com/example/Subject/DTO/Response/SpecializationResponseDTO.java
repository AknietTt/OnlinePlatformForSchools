package com.example.Subject.DTO.Response;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpecializationResponseDTO {
    @NotNull
    @Positive
    private int id;
    @NotEmpty
    private String name;
}
