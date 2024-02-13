package com.example.ddd.domain;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RootServiceImpl implements RootService {

    private final RootStore rootStore;
    private final RootReader rootReader;
    private final SubSeriesFactory subSeriesFactory;

    @Override
    @Transactional
    public String insertRoot(RootCommand.RootRequest request) {
        Root initRoot = request.toEntity();
        Root root = rootStore.store(initRoot);
        subSeriesFactory.store(request, root);
        return root.getToken();
    }

    @Override
    @Transactional
    public String insertSub(String rootToken, RootCommand.SubRequest request) {
        Root root = rootReader.get(rootToken);
        Sub initSub = request.toEntity(root);
        root.addSub(initSub);
        return initSub.getToken();
    }

    @Override
    @Transactional
    public void disableRoot(String rootToken) {
        Root root = rootReader.get(rootToken);
        root.disable();
    }

    @Override
    @Transactional
    public void disableSub(String rootToken, String subToken) {
        Root root = rootReader.get(rootToken);
        root.getSubList().stream()
                .filter(sub -> sub.getToken().equals(subToken))
                .findFirst()
                .orElseThrow(EntityNotFoundException::new)
                .disable();
    }

    @Override
    public RootInfo.Main select(String rootToken) {
        Root root = rootReader.get(rootToken);
        List<RootInfo.SubInfo> subInfoList = rootReader.getSubSeries(root);

        return new RootInfo.Main(root, subInfoList);
    }
}
