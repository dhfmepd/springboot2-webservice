package com.odhan.study.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity : 테이블과 링크될 클래스임을 나타냄
@Getter
@NoArgsConstructor
@Entity
public class Posts {

    //@Id : 해당 테이블의 PK필드
    //@GeneratedValue : PK의 생성규칙
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column : 테이블의 컬럼을 나타냄
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
