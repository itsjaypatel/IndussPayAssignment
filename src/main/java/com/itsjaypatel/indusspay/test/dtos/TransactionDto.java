package com.itsjaypatel.indusspay.test.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {

    @NotNull(message = "%s is required")
    private Long userId;

    private String txnId;

    @NotBlank(message = "%s is required")
    private String customerName;

    @NotBlank(message = "%s is required")
    private String service;

    @NotNull(message = "%s is required")
    @Min(value = 1,message = "%s should be positive")
    private Long amount;

    @NotNull(message = "%s is required")
    @Min(value = 0,message = "%s should be positive or zero")
    private Double gst;

    @NotNull(message = "%s is required")
    @Min(value = 0,message = "%s should be positive or zero")
    private Double commission;
}
