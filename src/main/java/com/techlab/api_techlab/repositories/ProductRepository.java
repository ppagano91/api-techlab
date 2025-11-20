package com.techlab.api_techlab.repositories;

import com.techlab.api_techlab.models.Product;
import java.util.ArrayList;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
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

  public ArrayList<Product> findAllProducts(String name, String description, Double price) {
    return this.products.stream()
        .filter(p -> name == null || p.getName().toLowerCase().contains(name.toLowerCase()))
        .filter(p -> description == null || p.getDescription().toLowerCase().contains(description.toLowerCase()))
        .filter(p -> price == null || (p.getPrice() != null && p.getPrice().equals(price)))
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public Product findProductById(int id) {
    return this.products.stream()
        .filter(p -> p.getId() == id)
        .findFirst()
        .orElse(null);
  }

  public Product saveProduct(Product newProduct) {
    this.updateId(newProduct);
    this.products.add(newProduct);

    return newProduct;
  }

  public void deleteProduct(int id) {
    this.products.removeIf(p -> p.getId() == id);
  }

  public void updateProduct(Product product) {
    for (int i = 0; i < this.products.size(); i++) {
      if (this.products.get(i).getId() == product.getId()) {
        this.products.set(i, product);
        return;
      }
    }
  }

  private void updateId(Product product){
    product.setId(nextId);
    nextId++;
  }

  private List<Product> loadProductsFromJSON(ObjectMapper objectMapper) {
    try {
      ClassPathResource resource = new ClassPathResource("data/data.json");
      try (InputStream is = resource.getInputStream()) {
        List<Product> products = objectMapper.readValue(
            is,
            new TypeReference<List<Product>>() {}
        );

        for (Product p : products) {
          this.updateId(p);
        }

        return products;
      }
    } catch (Exception e) {
      System.out.println("⚠️ Error al leer data.json: " + e.getMessage());
      return List.of(); // lista vacía
    }
  }


}
