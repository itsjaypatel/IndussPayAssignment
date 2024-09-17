package com.itsjaypatel.indusspay.test.configs;

import com.itsjaypatel.indusspay.test.dtos.TransactionDto;
import com.itsjaypatel.indusspay.test.entities.TransactionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(TransactionEntity.class, TransactionDto.class).setConverter(
                context -> {
                    TransactionEntity entity = context.getSource();
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
        );

        return modelMapper;
    }
}
