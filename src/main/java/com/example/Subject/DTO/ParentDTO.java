package com.example.Subject.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentDTO {

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
