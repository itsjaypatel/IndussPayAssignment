package com.itsjaypatel.indusspay.test.services;

import com.itsjaypatel.indusspay.test.dtos.TransactionDto;

import java.util.List;
import java.util.Map;

public interface TransactionService {

    void create(TransactionDto request);

    List<TransactionDto> getByUserIds(List<Long> userIds);

    Map<String,Object> findTxnInAmountRange(Long userId,Long minAmount,Long maxAmount);

    List<TransactionDto> findTxnOrderByAmountAscending();

}
