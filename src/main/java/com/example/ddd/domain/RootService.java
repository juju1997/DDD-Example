package com.example.ddd.domain;

import org.springframework.stereotype.Service;

public interface RootService {

    String insertRoot(RootCommand.RootRequest request);

    String insertSub(String rootToken, RootCommand.SubRequest request);

    void disableRoot(String rootToken);

    void disableSub(String rootToken, String subToken);

    RootInfo.Main select(String rootToken);
}
