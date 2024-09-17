package com.itsjaypatel.indusspay.test.service;

import com.itsjaypatel.indusspay.test.dtos.RegisterUserDto;
import com.itsjaypatel.indusspay.test.services.RegistrationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RegistrationServiceTest {

    @Autowired
    private RegistrationService registrationService;

    @Test
    public void register(){
        RegisterUserDto request = new RegisterUserDto();
        request.setFirstName("test");
        request.setLastName("test");
        request.setEmail("test@gmail.com");
        request.setPhone("1234567890");
        request.setBankName("SBI");
        request.setBankIfsc("SBIIFSC001");
        request.setAccountNumber("AC2323233232");

        Assertions.assertDoesNotThrow(()->
                registrationService.register(request));
    }
}
