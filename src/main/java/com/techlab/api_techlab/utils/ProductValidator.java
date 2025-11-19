package com.techlab.api_techlab.utils;

import com.techlab.api_techlab.models.Product;
import com.techlab.api_techlab.exceptions.InvalidProductException;

public class ProductValidator {

  public static void validate(Product product) {

    if (product == null) {
      throw new InvalidProductException("El producto no puede ser nulo.");
    }

    if (product.getName() == null || product.getName().isBlank()) {
      throw new InvalidProductException("El nombre del producto es obligatorio.");
    }

    if (product.getDescription() == null || product.getDescription().isBlank()) {
      throw new InvalidProductException("La descripción es obligatoria.");
    }

    if (product.getPrice() < 0) {
      throw new InvalidProductException("El precio no puede ser negativo.");
    }

    if (product.getStock() < 0) {
      throw new InvalidProductException("El stock no puede ser negativo.");
    }
  }
}
