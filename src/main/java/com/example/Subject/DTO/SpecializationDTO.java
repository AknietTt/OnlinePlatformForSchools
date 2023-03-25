package com.example.Subject.DTO;


import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpecializationDTO {
    @NotEmpty
    private String name;
}
