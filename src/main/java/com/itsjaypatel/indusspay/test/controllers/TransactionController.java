package com.itsjaypatel.indusspay.test.controllers;

import com.itsjaypatel.indusspay.test.dtos.TransactionDto;
import com.itsjaypatel.indusspay.test.dtos.UserIdListFilterDto;
import com.itsjaypatel.indusspay.test.services.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/txn/add")
    public ResponseEntity<?> add(
            @RequestBody @Valid TransactionDto request) {
        transactionService.create(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/txn/get/details")
    public ResponseEntity<?> getByUserIds(
            @RequestBody  @Valid UserIdListFilterDto request) {
        List<TransactionDto> transactions = transactionService.getByUserIds(request.getUserIds());
        return ResponseEntity.ok().body(transactions);
    }

    @GetMapping("/txn/amount/{initial_range}/{final_range}")
    public ResponseEntity<?> findTxnInAmountRange(
            @RequestParam Long userId,
            @PathVariable(value = "initial_range") Long minAmount,
            @PathVariable(value = "final_range") Long maxAmount
    ){
        Map<String,Object> response = transactionService.findTxnInAmountRange(userId, minAmount, maxAmount);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/sort/amount")
    public ResponseEntity<?> findTxnOrderByAmountAscending(){
        List<TransactionDto> response = transactionService
                .findTxnOrderByAmountAscending();
        return ResponseEntity.ok().body(response);
    }
}
