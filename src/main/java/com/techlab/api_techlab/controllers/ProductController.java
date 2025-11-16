package com.techlab.api_techlab.controllers;

import com.techlab.api_techlab.models.Product;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {


  @PostMapping("/products")
  // public Product addProduct(){
  public Map<String, String> addProduct(){
    // Product newProduct = new Product(...);
    Map<String, String> newProduct = new HashMap<>();
    newProduct.put("message", "Producto creado exitosamente");
    return newProduct;
  }

  @GetMapping("/products")
  public ArrayList<Product> getAllProducts(){

    ArrayList<Product> products = new ArrayList<Product>();

    return products;
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
