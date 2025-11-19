package com.techlab.api_techlab.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleNotFound(ProductNotFoundException ex) {

    Map<String, Object> error = new HashMap<>();
    error.put("error", true);
    error.put("status_code", 404);
    error.put("message", ex.getMessage());
    error.put("timestamp", LocalDateTime.now());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(InvalidProductException.class)
  public ResponseEntity<Map<String, Object>> handleInvalidProduct(InvalidProductException ex) {

    Map<String, Object> error = new HashMap<>();
    error.put("error", true);
    error.put("status_code", 400);
    error.put("message", ex.getMessage());
    error.put("timestamp", LocalDateTime.now());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  // Captura todo lo que no tenga handler específico
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {

    Map<String, Object> error = new HashMap<>();
    error.put("error", true);
    error.put("status_code", 500);
    error.put("message", ex.getMessage());
    error.put("timestamp", LocalDateTime.now());

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }
}
