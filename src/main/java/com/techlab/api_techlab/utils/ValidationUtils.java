package com.techlab.api_techlab.utils;

public class ValidationUtils {

  public static boolean isNullOrBlank(String value) {
    return value == null || value.trim().isEmpty();
  }
}
