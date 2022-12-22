package com.example.restapiinternshala.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, String> index(){
        Map<String, String> urls = new HashMap<>();

        urls.put("Swagger Documentation","http://localhost:8080/api-ui.html");

        return urls;
    }
}
