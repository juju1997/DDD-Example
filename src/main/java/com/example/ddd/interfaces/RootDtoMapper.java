package com.example.ddd.interfaces;

import com.example.ddd.domain.RootCommand;
import com.example.ddd.domain.RootInfo;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface RootDtoMapper {

    // insert
    @Mappings({@Mapping(source = "request.subList", target = "subRequestList")})
    RootCommand.RootRequest of(RootDto.InsertRootRequest request);

    // insert
    RootCommand.SubRequest of(RootDto.InsertSubRequest request);

    // update
    RootDto.InsertResponse of(String token);

    // select
    RootDto.Main of(RootInfo.Main main);


}
