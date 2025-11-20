package com.techlab.api_techlab.services;

import com.techlab.api_techlab.exceptions.InvalidProductException;
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

  public ArrayList<Product> getAll(String name, String description, Double price){
    return repository.findAllProducts(name, description, price);
  }

  public Product getById(int id) {

    if (id <= 0) {
      throw new InvalidProductException("El id debe ser un número entero positivo.");
    }

    Product product = repository.findProductById(id);

    if (product == null) {
      throw new ProductNotFoundException("El producto con id " + id + " no existe.");
    }

    return product;
  }

  public Product addProduct(Product product) {
    ProductValidator.validate(product);
    return this.repository.saveProduct(product);
  }

  public Product updateProduct(int id, Product productData) {

    if (id <= 0) {
      throw new InvalidProductException("El id debe ser un número entero positivo.");
    }

    Product foundProduct = repository.findProductById(id);

    if (foundProduct == null) {
      throw new ProductNotFoundException("El producto con id " + id + " no existe.");
    }

    productData.setId(id);

    ProductValidator.validate(productData);

    this.repository.updateProduct(productData);

    return foundProduct;
  }

  public Product deleteProduct(int id){
    if (id <= 0) {
      throw new InvalidProductException("El id debe ser un número entero positivo.");
    }

    Product foundProduct = repository.findProductById(id);

    if (foundProduct == null) {
      throw new ProductNotFoundException("El producto con id " + id + " no existe.");
    }

    this.repository.deleteProduct(id);

    return foundProduct;
  }
}
