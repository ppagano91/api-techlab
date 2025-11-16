package com.techlab.api_techlab;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Root {

  @GetMapping("/")
  public Map<String, String> home() {
    Map<String, String> respuesta  = new HashMap<>();
    respuesta.put("mensaje", "Server is running");
    respuesta.put("status", "200");
    respuesta.put("version", "1.0.0");
    return respuesta;
  }

}
