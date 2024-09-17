package com.itsjaypatel.indusspay.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BadRequestException.class,MethodArgumentTypeMismatchException.class,Exception.class})
    public ResponseEntity<?> handleBadRequestException(Exception ex) {
        Map<String,Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST);
        response.put("errors", List.of(ex.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        List<String> errorList = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = String.format(error.getDefaultMessage(), fieldName);
            errorList.add(errorMessage);
        });
        Map<String,Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST);
        response.put("errors", errorList);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
