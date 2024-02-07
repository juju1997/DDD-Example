package com.example.ddd.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(
        name = "child",
        indexes = {
                @Index(columnList = "token")
        }
)
public class Child extends BaseTimeEntity {

    private static final String PARENT_PREFIX = "child_";

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

}
