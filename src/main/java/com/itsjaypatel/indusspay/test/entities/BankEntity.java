package com.itsjaypatel.indusspay.test.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankEntity {

    @Id
    private String accountNumber;

    private String bankName;

    private String bankIfsc;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
