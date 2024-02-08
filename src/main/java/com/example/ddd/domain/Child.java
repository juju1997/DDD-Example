package com.example.ddd.domain;

import com.example.ddd.common.util.TokenGenerator;
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
@Table(name = "child")
public class Child extends BaseTimeEntity {

    private static final String CHILD_PREFIX = "child_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;

    private String childFieldOne;
    private String childFieldTwo;
    private Long childFieldThree;

    @ManyToOne(optional = false) // 부모 테이블 Non-Null
    @JoinColumn(name = "parent_id")
    private Parent parent;

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
    public Child(String childFieldOne, String childFieldTwo, Long childFieldThree) {
        if (StringUtils.isBlank(childFieldOne)) throw new InvalidParameterException("empty Child.childFieldOne");
        if (StringUtils.isBlank(childFieldTwo)) throw new InvalidParameterException("empty Child.childFieldTwo");
        if (childFieldThree == null) throw new InvalidParameterException("empty Child.childFieldThree");

        this.token = TokenGenerator.generateTokenWithPrefix(CHILD_PREFIX);
        this.childFieldOne = childFieldOne;
        this.childFieldTwo = childFieldTwo;
        this.childFieldThree = childFieldThree;
        this.status = Status.ENABLE;
    }

    public void enable() {
        this.status = Child.Status.ENABLE;
    }

    public void disable() {
        this.status = Child.Status.DISABLE;
    }
}
