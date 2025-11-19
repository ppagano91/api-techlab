package com.techlab.api_techlab.services;

import com.techlab.api_techlab.exceptions.ProductNotFoundException;
import com.techlab.api_techlab.models.Product;
import com.techlab.api_techlab.repositories.ProductRepository;
import com.techlab.api_techlab.utils.ProductValidator;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  private final ProductRepository repository;

  public ProductService(ProductRepository repo) {
    this.repository = repo;
  }

  public ArrayList<Product> getAll() {
    return repository.findAll();
  }

  public Product getById(int id) {
    Product product = repository.findById(id);

    if (product == null) {
      throw new ProductNotFoundException("El producto con id " + id + " no existe.");
    }

    return product;
  }

  public Product addProduct(Product product) {
    ProductValidator.validate(product);
    return this.repository.save(product);
  }
}
