package com.example.corstest;


import com.example.dto.ChartData;
import com.example.dto.CreatePostDto;
import com.example.dto.LoginDto;
import com.example.dto.UserInfoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public ResponseEntity<?> postData(@RequestBody LoginDto loginDto){
        System.out.println(loginDto);

        return ResponseEntity.ok().body(loginDto.getUsername());
    }


    @PostMapping("/createPost")
    public ResponseEntity<?> createPost(@RequestBody CreatePostDto createPostDto){
        System.out.println(createPostDto);

        CreatePostDto createPostDto1 = new CreatePostDto("title1", "content1");
        CreatePostDto createPostDto2 = new CreatePostDto("title2", "content2");
        CreatePostDto createPostDto3 = new CreatePostDto("title3", "content3");


        List<CreatePostDto> list = new ArrayList<>();
        list.add(createPostDto);
        list.add(createPostDto1);
        list.add(createPostDto2);
        list.add(createPostDto3);


        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/userInfo")
    public ResponseEntity<?> userList(){

        List<UserInfoDto> list = new ArrayList<>();

        for(int i=0; i<100; i++){
            UserInfoDto userInfoDto = new UserInfoDto();
            userInfoDto.setId(i);
            userInfoDto.setFirst_name("L" + i);
            userInfoDto.setLast_name("S" + i);
            userInfoDto.setEmail("email" + i);
            userInfoDto.setGender("gender");
            list.add(userInfoDto);
        }
        return ResponseEntity.ok().body(list);
    }



}
