package com.example.ddd.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class RootInfo {

    @Getter
    @ToString
    public static class Main {
        private final String token;
        private final String rootFieldOne;
        private final String rootFieldTwo;
        private final Long rootFieldThree;
        private final List<SubInfo> subList;
        private final Root.Status status;

        public Main(Root root, List<SubInfo> subInfoList) {
            this.token = root.getToken();
            this.rootFieldOne = root.getRootFieldOne();
            this.rootFieldTwo = root.getRootFieldTwo();
            this.rootFieldThree = root.getRootFieldThree();
            this.subList = subInfoList;
            this.status = root.getStatus();
        }
    }

    @Getter
    @ToString
    public static class SubInfo {
        private final String token;
        private final String subFieldOne;
        private final String subFieldTwo;
        private final Long subFieldThree;
        private final Sub.Status status;

        public SubInfo(Sub sub) {
            this.token = sub.getToken();
            this.subFieldOne = sub.getSubFieldOne();
            this.subFieldTwo = sub.getSubFieldTwo();
            this.subFieldThree = sub.getSubFieldThree();
            this.status = sub.getStatus();
        }
    }
}
