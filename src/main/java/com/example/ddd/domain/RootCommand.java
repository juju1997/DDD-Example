package com.example.ddd.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;


public class RootCommand {

    @Getter
    @Builder
    @ToString
    public static class RootRequest {
        private final String rootFieldOne;
        private final String rootFieldTwo;
        private final Long rootFieldThree;
        private final List<SubRequest> subRequestList;

        public Root toEntity() {
            return Root.builder()
                    .rootFieldOne(rootFieldOne)
                    .rootFieldTwo(rootFieldTwo)
                    .rootFieldThree(rootFieldThree)
                    .build();
        }
    }

    @Getter
    @Builder
    @ToString
    public static class SubRequest {
        private final String subFieldOne;
        private final String subFieldTwo;
        private final Long subFieldThree;

        public Sub toEntity(Root root) {
            return Sub.builder()
                    .root(root)
                    .subFieldOne(subFieldOne)
                    .subFieldTwo(subFieldTwo)
                    .subFieldThree(subFieldThree)
                    .build();
        }
    }

}
