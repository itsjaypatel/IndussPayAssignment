package com.itsjaypatel.indusspay.test.dtos;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDto {

    private Long userId;

    private String bankName;

    private String bankIfsc;

    private String accountNumber;
}
