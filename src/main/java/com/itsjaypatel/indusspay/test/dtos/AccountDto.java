package com.itsjaypatel.indusspay.test.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    private Long userId;

    private String bankName;

    private String bankIfsc;

    private String accountNumber;
}
