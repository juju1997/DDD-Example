package com.example.ddd.domain;

import com.example.ddd.common.util.TokenGenerator;
import com.example.ddd.domain.auditEntity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.security.InvalidParameterException;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "sub")
public class Sub extends BaseTimeEntity {

    private static final String SUB_PREFIX = "sub_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;

    @ManyToOne(optional = false) // 부모 테이블 Non-Null
    @JoinColumn(name = "root_id")
    private Root root;

    private String subFieldOne;
    private String subFieldTwo;
    private Long subFieldThree;


    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("활성화"),
        DISABLE("비활성화");
        private final String description;
    }

    @Builder
    public Sub(Root root, String subFieldOne, String subFieldTwo, Long subFieldThree) {
        if (root == null) throw  new InvalidParameterException("empty Sub.Root");
        if (StringUtils.isBlank(subFieldOne)) throw new InvalidParameterException("empty Sub.subFieldOne");
        if (StringUtils.isBlank(subFieldTwo)) throw new InvalidParameterException("empty Sub.subFieldTwo");
        if (subFieldThree == null) throw new InvalidParameterException("empty Sub.subFieldThree");

        this.token = TokenGenerator.generateTokenWithPrefix(SUB_PREFIX);
        this.root = root;
        this.subFieldOne = subFieldOne;
        this.subFieldTwo = subFieldTwo;
        this.subFieldThree = subFieldThree;
        this.status = Status.ENABLE;
    }

    public void enable() {
        this.status = Sub.Status.ENABLE;
    }

    public void disable() {
        this.status = Sub.Status.DISABLE;
    }
}
