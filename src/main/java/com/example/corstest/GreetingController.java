package com.example.corstest;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요?";
    }
}
