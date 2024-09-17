package com.itsjaypatel.indusspay.test.services.impl;

import com.itsjaypatel.indusspay.test.dtos.AccountDto;
import com.itsjaypatel.indusspay.test.dtos.TransactionDto;
import com.itsjaypatel.indusspay.test.dtos.UserDto;
import com.itsjaypatel.indusspay.test.entities.AccountEntity;
import com.itsjaypatel.indusspay.test.entities.TransactionEntity;
import com.itsjaypatel.indusspay.test.entities.UserEntity;
import com.itsjaypatel.indusspay.test.exceptions.BadRequestException;
import com.itsjaypatel.indusspay.test.repositories.AccountRepository;
import com.itsjaypatel.indusspay.test.repositories.TransactionRepository;
import com.itsjaypatel.indusspay.test.repositories.UserRepository;
import com.itsjaypatel.indusspay.test.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    @Override
    public void create(TransactionDto request) {
        UserEntity user = userRepository
                .findById(request.getUserId())
                .orElseThrow(() -> new BadRequestException("User not found"));

        transactionRepository.save(
                    TransactionEntity
                    .builder()
                            .txnId("TXN" + System.currentTimeMillis())
                            .user(user)
                            .customerName(request.getCustomerName())
                            .service(request.getService())
                            .amount(request.getAmount())
                            .gst(request.getGst())
                            .commission(request.getCommission())
                            .build()
                );


    }

    @Override
    public List<TransactionDto> getByUserIds(List<Long> userIds) {
        if(userIds == null){
            return transactionRepository.findAll()
                    .stream()
                    .map(entity -> modelMapper.map(entity, TransactionDto.class))
                    .collect(Collectors.toList());
        }

        return transactionRepository
                .findByUserIdIn(userIds)
                .stream()
                .map(entity -> modelMapper.map(entity, TransactionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String,Object> findTxnInAmountRange(Long userId,Long minAmount,Long maxAmount){

        List<TransactionEntity> transactions = transactionRepository
                .findByUserIdAndAmountBetween(userId,minAmount,maxAmount);
        if(transactions.isEmpty()){
            throw new BadRequestException("No Transaction found");
        }

        UserEntity userEntity = transactions.getFirst().getUser();
        AccountEntity accountEntity = userEntity.getAccount();

        UserDto userDetail = modelMapper.map(userEntity, UserDto.class);
        AccountDto bankDetail = modelMapper.map(accountEntity, AccountDto.class);
        bankDetail.setUserId(userDetail.getId());

        Map<String,Object> response = new HashMap<>();
        response.put("txns",
                transactions.stream()
                .map(entity -> modelMapper.map(entity, TransactionDto.class))
                .collect(Collectors.toList()));
        response.put("userDetail",userDetail);
        response.put("bankDetail",bankDetail);

        return response;
    }

    @Override
    public List<TransactionDto> findTxnOrderByAmountAscending(){
        Sort sort = Sort.by(Order.asc("amount"));
        return transactionRepository.findAll(sort)
                .stream()
                .map(txn -> modelMapper.map(txn, TransactionDto.class))
                .collect(Collectors.toList());
    }
}
