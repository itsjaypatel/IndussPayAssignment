package com.itsjaypatel.indusspay.test.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {

    @NotBlank(message = "%s is required")
    @Length(min = 3,message = "%s should have minimum length 3")
    private String firstName;

    @NotBlank(message = "%s is required")
    @Length(min = 3,message = "%s should have minimum length 3")
    private String lastName;

    @NotBlank(message = "%s is required")
    @Email(message = "%s not follows proper email format")
    private String email;

    @NotBlank(message = "%s is required")
    @Length(min = 10,max = 10,message = "%s should have length 10")
    private String phone;

    @NotBlank(message = "%s is required")
    @Length(min = 3,message = "%s should have minimum length 3")
    private String bankName;

    @NotBlank(message = "%s is required")
    @Length(min = 6,message = "%s should have minimum length 6")
    private String bankIfsc;

    @NotBlank(message = "%s is mandatory")
    @Length(min = 12,message = "%s should have minimum length 12")
    private String accountNumber;
}
