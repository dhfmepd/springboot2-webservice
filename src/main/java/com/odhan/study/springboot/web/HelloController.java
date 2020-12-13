package com.odhan.study.springboot.web;

import com.odhan.study.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController : 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 줍니다.
@RestController
public class HelloController {
    //@GetMapping : HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어줍니다.
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}