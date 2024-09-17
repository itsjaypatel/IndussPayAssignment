package com.itsjaypatel.indusspay.test.utlis;

import com.itsjaypatel.indusspay.test.dtos.TransactionDto;
import com.itsjaypatel.indusspay.test.entities.TransactionEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CommonUtil {

    public TransactionDto convertTransactionDtoFromTransactionEntity(TransactionEntity entity) {
        return TransactionDto
                .builder()
                .userId(entity.getUser().getId())
                .txnId(entity.getTxnId())
                .customerName(entity.getCustomerName())
                .service(entity.getService())
                .amount(entity.getAmount())
                .gst(entity.getGst())
                .commission(entity.getCommission())
                .build();
    }
}
