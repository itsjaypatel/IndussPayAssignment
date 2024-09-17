package com.itsjaypatel.indusspay.test.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;
}
