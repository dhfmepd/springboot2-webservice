package com.odhan.study.springboot.service;

import com.odhan.study.springboot.domain.posts.Posts;
import com.odhan.study.springboot.domain.posts.PostsRepository;
import com.odhan.study.springboot.web.dto.PostsResponseDto;
import com.odhan.study.springboot.web.dto.PostsSaveRequestDto;
import com.odhan.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto reqeustDto) {
        return postsRepository.save(reqeustDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto reqeustDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        posts.update(reqeustDto.getTitle(), reqeustDto.getContent());
        return id;
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }
}
