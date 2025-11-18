package com.techlab.api_techlab.repositories;

import com.techlab.api_techlab.models.Product;
import java.util.ArrayList;
import java.io.InputStream;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

@Repository
public class ProductRepository {
  private final ArrayList<Product> products = new ArrayList<>();
  private static int nextId = 1;

  public ProductRepository(ObjectMapper objectMapper) {
    this.products.addAll(loadProductsFromJSON(objectMapper));
  }

  public ArrayList<Product> findAll() {
    return this.products;
  }

  public Product findById(int id) {
    return this.products.stream()
        .filter(p -> p.getId() == id)
        .findFirst()
        .orElse(null);
  }

  public Product save(Product newProduct) {
    newProduct.setId(nextId);
    nextId++;
    this.products.add(newProduct);

    return newProduct;
  }

  public void delete(int id) {
    this.products.removeIf(p -> p.getId() == id);
  }

  public void update(Product actualizado) {
    for (int i = 0; i < this.products.size(); i++) {
      if (this.products.get(i).getId() == actualizado.getId()) {
        this.products.set(i, actualizado);
        return;
      }
    }
  }

  private List<Product> loadProductsFromJSON(ObjectMapper objectMapper) {
    try {
      ClassPathResource resource = new ClassPathResource("data/data.json");
      try (InputStream is = resource.getInputStream()) {
        return objectMapper.readValue(
            is,
            new TypeReference<List<Product>>() {}
        );
      }
    } catch (Exception e) {
      System.out.println("⚠️ Error al leer data.json: " + e.getMessage());
      return List.of(); // lista vacía si falla
    }
  }


}
