package com.ll.sb_25_01.global.jpa.baseEntity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@MappedSuperclass
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = PROTECTED)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @CreatedDate
    private LocalDateTime createDate;
    @Setter
    @LastModifiedDate
    private LocalDateTime modifyDate;
}
