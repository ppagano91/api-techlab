package com.techlab.api_techlab.models;

public class Product {
  private static int nextId = 1;
  private int id;
  private String name;
  private String description;
  private Integer stock;
  private Double price;

  // 🔹 Constructores completo
  public Product(String name, String description, Integer stock, Double price) {
    this.name = name;
    this.description = description;
    this.stock = stock;
    this.price = price;
  }

  public Product(String name, String description) {
    this(name, description, 0, 0.0);
  }

  public Product() {
  }

  // Métodos
  public int getId() { return id; }
  public void setId(int id) {
    this.id = id;
  }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public Integer getStock() { return stock; }
  public void setStock(Integer stock) { this.stock = stock; }

  public Double getPrice() { return price; }
  public void setPrice(Double price) { this.price = price; }

  public void updateStock(int subtract){
    if (this.stock >= subtract){
      this.stock -= subtract;
    }
  }

  @Override
  public String toString() {
    return String.format("%-5d %-30s", id, name);
  }
}
