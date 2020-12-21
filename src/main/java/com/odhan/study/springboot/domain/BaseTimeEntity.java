package com.odhan.study.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
//JPA Entity 클래스들이 이 Class를 상속할 경우 필드들을 컬럼으로 인식
@MappedSuperclass
//Auditing 기능을 포함
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    //Entity가 저장 될 때 저장
    @CreatedDate
    private LocalDateTime createDate;

    //Entity가 변경 될 떄 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
