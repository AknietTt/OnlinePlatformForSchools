package com.example.Subject.DTO.Response;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectResponse {
    @NotEmpty
    @Size(min = 3,max = 30)
    private String nameRu;

    private String descriptionRu;
}
