package com.example.ddd.infrastructure;

import com.example.ddd.domain.Root;
import com.example.ddd.domain.RootStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RootStoreImpl implements RootStore {

    private final RootRepository rootRepository;

    @Override
    public Root store(Root root) {
        return rootRepository.save(root);
    }
}
