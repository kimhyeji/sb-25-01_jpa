package com.ll.sb_25_01.domain.member.member.entity;

import com.ll.sb_25_01.global.jpa.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Entity
@SuperBuilder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Getter
@Setter
@ToString(callSuper = true)
public class Member extends BaseEntity {
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    private String username;
    private String password;
}
