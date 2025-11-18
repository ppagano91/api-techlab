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
  public Product addProduct(@RequestBody Product newProduct){
    return this.service.addProduct(newProduct);
  }

  @GetMapping("/products")
  public Map<String, Object> getAllProducts(){

    ArrayList<Product> products = this.service.getAll();
    Map<String, Object> response = new HashMap<>();
    response.put("productos", products);
    response.put("error", "false");
    response.put("status_code", "200");



    return response;
  }

  @GetMapping("/products/{id}")
  public ArrayList<Product> getProductById(@PathVariable int id){

    ArrayList<Product> products = new ArrayList<Product>();

    return products;
  }

  @GetMapping("/products/search")
  public ArrayList<Product> searchProductByName(@RequestParam String name, @RequestParam String description){

    ArrayList<Product> products = new ArrayList<Product>();

    return products;
  }

  @PutMapping("/products/{id}")
  public Map<String, String> editProduct(@PathVariable int id){
    Map<String, String> editProduct = new HashMap<>();
    editProduct.put("message", "Producto editado exitosamente");
    return editProduct;
  }

  @DeleteMapping("/products/{id}")
  public Map<String, String> deleteProduct(@PathVariable(name = "id") int productId){
    Map<String, String> editProduct = new HashMap<>();
    editProduct.put("message", "Producto eliminado correctamente");
    return editProduct;
  }
}
