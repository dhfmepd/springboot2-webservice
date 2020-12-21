package com.odhan.study.springboot.service;

import com.odhan.study.springboot.domain.posts.Posts;
import com.odhan.study.springboot.domain.posts.PostsRepository;
import com.odhan.study.springboot.web.dto.PostsListResponseDto;
import com.odhan.study.springboot.web.dto.PostsResponseDto;
import com.odhan.study.springboot.web.dto.PostsSaveRequestDto;
import com.odhan.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    //readOnly : 트랜잭션 범위는 유지하되 조회 기능만 남겨두어 속도 개선효과
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
        //.map(PostsListResponseDto::new) = .map(posts -> new PostsListResponseDto(posts))
        //Posts의 stream을 map을 통해 PostsListResponseDto로 변환 후 List로 반환
    }
}
