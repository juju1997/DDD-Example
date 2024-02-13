package com.example.ddd.application;


import com.example.ddd.domain.RootCommand;
import com.example.ddd.domain.RootInfo;
import com.example.ddd.domain.RootService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RootFacade {

    private final RootService rootService;

    public String insertRoot(RootCommand.RootRequest request) {
        return rootService.insertRoot(request);
    }

    public String insertSub(String rootToken, RootCommand.SubRequest request) {
        return rootService.insertSub(rootToken, request);
    }

    public void disableRoot(String rootToken) {
        rootService.disableRoot(rootToken);
    }

    public void disableSub(String rootToken, String subToken) {
        rootService.disableSub(rootToken, subToken);
    }

    public RootInfo.Main select(String rootToken) {
        return rootService.select(rootToken);
    }

}
