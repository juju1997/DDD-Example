package com.example.ddd.infrastructure;

import com.example.ddd.domain.Root;
import com.example.ddd.domain.RootInfo;
import com.example.ddd.domain.RootReader;
import com.example.ddd.domain.Sub;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RootReaderImpl implements RootReader {

    private final RootRepository rootRepository;

    @Override
    public List<Root> get() {
        return rootRepository.findAll();
    }

    @Override
    public Root get(String rootToken) {
        return rootRepository.findByToken(rootToken)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<RootInfo.SubInfo> getSubSeries(Root root) {
        List<Sub> subList = root.getSubList();
        return subList.stream()
                .map(RootInfo.SubInfo::new).collect(Collectors.toList());
    }
}
