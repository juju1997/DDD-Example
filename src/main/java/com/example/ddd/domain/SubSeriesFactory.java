package com.example.ddd.domain;

import java.util.List;

public interface SubSeriesFactory {
    List<Sub> store(RootCommand.RootRequest request, Root root);
}
