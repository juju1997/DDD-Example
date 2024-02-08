package com.example.ddd.domain;

import com.example.ddd.common.util.TokenGenerator;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "parent")
public class Parent extends BaseTimeEntity {

    private static final String PARENT_PREFIX = "parent_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;

    private String parentFieldOne;
    private String parentFieldTwo;
    private Long parentFieldThree;

    @ToString.Exclude // ToString 순환 참조 방지
    @OrderBy("createdAt DESC")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.PERSIST) // 하위 Domain 영속성 전파
    private List<Child> childList = new LinkedList<>();

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
    public Parent(String parentFieldOne, String parentFieldTwo, Long parentFieldThree) {
        if (StringUtils.isBlank(parentFieldOne)) throw new InvalidParameterException("empty Parent.parentFiledOne");
        if (StringUtils.isBlank(parentFieldTwo)) throw new InvalidParameterException("empty Parent.parentFieldTwo");
        if (parentFieldThree == null) throw new InvalidParameterException("empty Parent.parentFiledThree");

        this.token = TokenGenerator.generateTokenWithPrefix(PARENT_PREFIX);
        this.parentFieldOne = parentFieldOne;
        this.parentFieldTwo = parentFieldTwo;
        this.parentFieldThree = parentFieldThree;
        this.status = Status.ENABLE;
    }

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }
}
