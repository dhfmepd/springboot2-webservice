package com.odhan.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//JPA Auditing 어노테이션 활성화
@EnableJpaAuditing
//@SpringBootApplication : 스프링부트의 자동설정, 스피링 Bean 읽기와 생성을 모두 자동으로 설정
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //SpringApplication.run : 내장 Was를 실행
        SpringApplication.run(Application.class, args);
    }
}
