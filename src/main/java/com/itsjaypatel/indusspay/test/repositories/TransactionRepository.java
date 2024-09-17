package com.itsjaypatel.indusspay.test.repositories;

import com.itsjaypatel.indusspay.test.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, String>, PagingAndSortingRepository<TransactionEntity, String> {

    List<TransactionEntity> findByUserIdIn(Collection<Long> userIds);

    List<TransactionEntity> findByUserIdAndAmountBetween(Long user_id, Long amount, Long amount2);

}
