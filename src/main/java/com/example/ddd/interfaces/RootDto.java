package com.example.ddd.interfaces;

import com.example.ddd.domain.Root;
import com.example.ddd.domain.RootInfo;
import com.example.ddd.domain.Sub;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class RootDto {


    @Getter
    @Builder
    @ToString
    public static class Main {
        private final String token;
        private final String rootFieldOne;
        private final String rootFieldTwo;
        private final Long rootFieldThree;
        private final Root.Status status;
        private final List<RootInfo.SubInfo> subList;
    }

    @Getter
    @Builder
    @ToString
    public static class SubInfo {
        private final String token;
        private final String subFieldOne;
        private final String subFieldTwo;
        private final Long subFieldThree;
        private final Sub.Status status;
    }

    @Getter
    @Setter
    @ToString
    public static class InsertRootRequest {
        private String rootFieldOne;
        private String rootFieldTwo;
        private Long rootFieldThree;
        private List<InsertSubRequest> subList;
    }

    @Getter
    @Setter
    @ToString
    public static class InsertSubRequest {
        private String rootToken;
        private String subFieldOne;
        private String subFieldTwo;
        private Long subFieldThree;
    }

    @Getter
    @Setter
    @ToString
    public static class disableRootRequest {
        private String rootToken;
    }

    @Getter
    @Setter
    @ToString
    public static class disableSubRequest {
        private String rootToken;
        private String subToken;
    }

    @Getter
    @Setter
    @ToString
    public static class InsertResponse {
        private String token;
    }
}
