package com.itsjaypatel.indusspay.test.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionEntity {

    @Id
    private String txnId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String customerName;

    private String service;

    private Long amount;

    private Double gst;

    private Double commission;
}
