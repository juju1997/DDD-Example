package com.example.ddd.domain;

import com.example.ddd.common.util.TokenGenerator;
import com.example.ddd.domain.auditEntity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;


/**
 * Aggregate Root Entity
 * */
@Getter
@Entity
@NoArgsConstructor
@Table(name = "root")
public class Root extends BaseTimeEntity {

    private static final String ROOT_PREFIX = "root_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;

    private String rootFieldOne;
    private String rootFieldTwo;
    private Long rootFieldThree;

    @ToString.Exclude // ToString 순환 참조 방지
    @OrderBy("createdAt DESC")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "root", cascade = CascadeType.PERSIST) // 하위 Domain 영속성 전파
    private List<Sub> subList;

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
    public Root(String rootFieldOne, String rootFieldTwo, Long rootFieldThree) {
        if (StringUtils.isBlank(rootFieldOne)) throw new InvalidParameterException("empty Root.rootFiledOne");
        if (StringUtils.isBlank(rootFieldTwo)) throw new InvalidParameterException("empty Root.rootFieldTwo");
        if (rootFieldThree == null) throw new InvalidParameterException("empty Root.rootFiledThree");

        this.token = TokenGenerator.generateTokenWithPrefix(ROOT_PREFIX);
        this.rootFieldOne = rootFieldOne;
        this.rootFieldTwo = rootFieldTwo;
        this.rootFieldThree = rootFieldThree;
        this.subList = new LinkedList<>();
        this.status = Status.ENABLE;
    }

    public void addSub(Sub newSub) {
        subList.add(newSub);
    }


    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }
}
