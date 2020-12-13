package com.odhan.study.springboot.web;

import com.odhan.study.springboot.service.PostsService;
import com.odhan.study.springboot.web.dto.PostsResponseDto;
import com.odhan.study.springboot.web.dto.PostsSaveRequestDto;
import com.odhan.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //@PutMapping : HTTP Method인 Put의 요청을 받을 수 있는 API를 만들어줍니다.
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
