package com.itsjaypatel.indusspay.test.controllers;

import com.itsjaypatel.indusspay.test.dtos.RegisterUserDto;
import com.itsjaypatel.indusspay.test.services.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/user/add")
    public ResponseEntity<?> register(
            @RequestBody @Valid RegisterUserDto request) {

        registrationService.register(request);
        return ResponseEntity.ok().build();
    }
}
