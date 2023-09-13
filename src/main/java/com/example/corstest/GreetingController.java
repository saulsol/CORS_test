package com.example.corstest;


import com.example.dto.ChartData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
public class GreetingController {

    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요?";
    }


    @GetMapping("/chart")
    public ResponseEntity<?> chartData() throws JsonProcessingException {

        List<ChartData> list = new ArrayList<>();
        ChartData data = new ChartData("a", 10);
        ChartData data1 = new ChartData("b", 15);
        ChartData data2 = new ChartData("c", 18);
        ChartData data3 = new ChartData("d", 60);

        list.add(data);
        list.add(data1);
        list.add(data2);
        list.add(data3);
        return ResponseEntity.ok().body(list);
    }


}
