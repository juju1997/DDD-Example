package com.example.ddd.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface RootReader {

    List<Root> get();

    Root get(String rootToken);

    List<RootInfo.SubInfo> getSubSeries(Root root);

}
