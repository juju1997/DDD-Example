package com.example.ddd.infrastructure;

import com.example.ddd.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SubSeriesFactoryImpl implements SubSeriesFactory {

    private final SubStore subStore;

    @Override
    public List<Sub> store(RootCommand.RootRequest request, Root root) {
        List<RootCommand.SubRequest> subRequestList = request.getSubRequestList();
        if (CollectionUtils.isEmpty(subRequestList)) return Collections.emptyList();

        return subRequestList.stream()
                .map(subRequest -> {
                    Sub storeSub = subRequest.toEntity(root);
                    return subStore.store(storeSub);
                }).collect(Collectors.toList());

    }
}
