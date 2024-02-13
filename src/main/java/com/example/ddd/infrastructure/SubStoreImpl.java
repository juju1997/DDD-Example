package com.example.ddd.infrastructure;

import com.example.ddd.domain.Sub;
import com.example.ddd.domain.SubStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubStoreImpl implements SubStore {

    private final SubRepository subRepository;

    @Override
    public Sub store(Sub sub) {
        return subRepository.save(sub);
    }
}
