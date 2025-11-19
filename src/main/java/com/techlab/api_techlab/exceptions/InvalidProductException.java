package com.techlab.api_techlab.exceptions;

public class InvalidProductException extends RuntimeException {

  public InvalidProductException(String message) {
    super(message);
  }
}