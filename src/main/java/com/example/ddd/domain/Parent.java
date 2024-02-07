package com.example.ddd.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(
        name = "parent",
        indexes = {
                @Index(columnList = "token")
        }
)
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

}
