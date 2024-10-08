package com.itsjaypatel.indusspay.test.services.impl;

import com.itsjaypatel.indusspay.test.dtos.RegisterUserDto;
import com.itsjaypatel.indusspay.test.entities.AccountEntity;
import com.itsjaypatel.indusspay.test.entities.UserEntity;
import com.itsjaypatel.indusspay.test.exceptions.BadRequestException;
import com.itsjaypatel.indusspay.test.repositories.AccountRepository;
import com.itsjaypatel.indusspay.test.repositories.UserRepository;
import com.itsjaypatel.indusspay.test.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Override
    public void register(RegisterUserDto request) {

        userRepository
                .findByEmailOrPhone(request.getEmail(),request.getPhone())
                .ifPresent(_ -> { throw new BadRequestException("User already exists with email or phone"); });

        accountRepository
                .findByAccountNumber(request.getAccountNumber())
                .ifPresent(_ -> { throw new BadRequestException("user already exists with account number"); });

        AccountEntity accountEntity = accountRepository.save(
                AccountEntity
                        .builder()
                        .bankName(request.getBankName())
                        .bankIfsc(request.getBankIfsc())
                        .accountNumber(request.getAccountNumber())
                        .build());

        UserEntity savedUserEntity = userRepository.save(
                UserEntity
                .builder()
                .email(request.getEmail())
                .phone(request.getPhone())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .account(accountEntity)
                .build());
    }
}
