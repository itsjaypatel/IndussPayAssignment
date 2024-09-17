package com.itsjaypatel.indusspay.test.repositories;

import com.itsjaypatel.indusspay.test.entities.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<BankEntity,String> {

    Optional<BankEntity> findByAccountNumber(String accountNumber);
    Optional<BankEntity> findByUserId(Long userId);
}
