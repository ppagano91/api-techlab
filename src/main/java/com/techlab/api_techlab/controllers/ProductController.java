package com.techlab.api_techlab.controllers;

import com.techlab.api_techlab.models.Product;
import com.techlab.api_techlab.services.ProductService;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private ProductService service;

  public ProductController(ProductService productService){
    this.service = productService;
  }


  @PostMapping("/products")
  // public Product addProduct(){
  public Map<String, Object> addProduct(@RequestBody Product newProduct){
    Product savedProduct = this.service.addProduct(newProduct);

    Map<String, Object> response = new HashMap<>();
    response.put("product", savedProduct);
    response.put("status_code", 201);
    response.put("error", false);
    response.put("message", "Producto agregado correctamente");

    return response;

  }

  @GetMapping("/products")
  public Map<String, Object> getAllProducts(
      @RequestParam(required = false, defaultValue = "") String name,
      @RequestParam(required = false, defaultValue = "") String description,
      @RequestParam(required = false) Double price
  ){

    ArrayList<Product> products = this.service.getAll(name, description, price);
    Map<String, Object> response = new HashMap<>();
    response.put("productos", products);
    response.put("error", "false");
    response.put("status_code", "200");



    return response;
  }

  @GetMapping("/products/{id}")
  public Map<String, Object> getProductById(@PathVariable int id){

    Product product = this.service.getById(id);

    Map<String, Object> response = new HashMap<>();
    response.put("productos", product);
    response.put("error", "false");
    response.put("status_code", "200");

    return response;
  }

  @GetMapping("/products/search")
  public Map<String, Object> searchProductByName(@RequestParam(required = false, defaultValue = "") String name,
      @RequestParam(required = false, defaultValue = "") String description,
      @RequestParam(required = false) Double price
  ){

    ArrayList<Product> products = this.service.getAll(name, description, price);
    Map<String, Object> response = new HashMap<>();
    response.put("productos", products);
    response.put("error", "false");
    response.put("status_code", "200");



    return response;
  }

  @PutMapping("/products/{id}")
  public Map<String, Object> editProduct(@PathVariable int id, @RequestBody Product productData){
    Map<String, Object> response = new HashMap<>();
    Product updatedProduct = this.service.updateProduct(id, productData);
    response.put("message", "Producto editado correctamente");
    response.put("status_code", 200);
    response.put("product", updatedProduct);
    return response;
  }

  @DeleteMapping("/products/{id}")
  public Map<String, Object> deleteProduct(@PathVariable(name = "id") int productId){
    Map<String, Object> response = new HashMap<>();
    Product productDeleted = this.service.deleteProduct(productId);

    response.put("message", "Producto eliminado correctamente");
    response.put("status_code", 200);
    response.put("product", productDeleted);
    return response;
  }
}
