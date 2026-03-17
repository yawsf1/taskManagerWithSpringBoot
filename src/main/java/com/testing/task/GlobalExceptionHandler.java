package com.testing.task;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice  // tells Spring: this class handles errors globally
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)  // catch validation errors
    public ResponseEntity<Map<String, String>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>(); // like an array in Laravel

        ex.getBindingResult()
                .getFieldErrors()  // get all field errors
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage())); // field -> message

        return ResponseEntity.badRequest().body(errors); // return 400 with errors
    }
}