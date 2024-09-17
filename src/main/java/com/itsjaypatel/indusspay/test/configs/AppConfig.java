package com.itsjaypatel.indusspay.test.configs;

import com.itsjaypatel.indusspay.test.dtos.AccountDto;
import com.itsjaypatel.indusspay.test.dtos.TransactionDto;
import com.itsjaypatel.indusspay.test.entities.AccountEntity;
import com.itsjaypatel.indusspay.test.entities.TransactionEntity;
import com.itsjaypatel.indusspay.test.utlis.CommonUtil;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .typeMap(TransactionEntity.class, TransactionDto.class)
                .setConverter(context -> CommonUtil.convertTransactionDtoFromTransactionEntity(context.getSource()));
        return modelMapper;
    }
}
