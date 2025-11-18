package com.techlab.api_techlab.services;

import com.techlab.api_techlab.models.Product;
import com.techlab.api_techlab.repositories.ProductRepository;
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
    return repository.findById(id);
  }

  public Product addProduct(Product product) {
    return this.repository.save(product);
  }

}
