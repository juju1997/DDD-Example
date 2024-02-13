package com.example.ddd.interfaces;

import com.example.ddd.application.RootFacade;
import com.example.ddd.common.response.CommonResponse;
import com.example.ddd.domain.RootCommand;
import com.example.ddd.domain.RootInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/root")
public class RootApiController {

    private final RootFacade rootFacade;
    private final RootDtoMapper rootDtoMapper;

    @PostMapping
    public CommonResponse<?> insertRoot(@RequestBody RootDto.InsertRootRequest request) {
        RootCommand.RootRequest command = rootDtoMapper.of(request);
        String token = rootFacade.insertRoot(command);
        RootDto.InsertResponse response = rootDtoMapper.of(token);
        return CommonResponse.success(response);
    }

    @PostMapping("/add-sub")
    public CommonResponse<?> insertSub(@RequestBody RootDto.InsertSubRequest request) {
        String rootToken = request.getRootToken();
        RootCommand.SubRequest command = rootDtoMapper.of(request);
        String token = rootFacade.insertSub(rootToken, command);
        RootDto.InsertResponse response = rootDtoMapper.of(token);
        return CommonResponse.success(response);
    }

    @PostMapping("/disable-root")
    public CommonResponse<?> disableRoot(@RequestBody RootDto.disableRootRequest request) {
        String rootToken = request.getRootToken();
        rootFacade.disableRoot(rootToken);
        return CommonResponse.success();
    }

    @PostMapping("/disable-sub")
    public CommonResponse<?> disableSub(@RequestBody RootDto.disableSubRequest request) {
        String rootToken = request.getRootToken();
        String subToken = request.getSubToken();
        rootFacade.disableSub(rootToken, subToken);
        return CommonResponse.success();
    }

    @GetMapping("/{rootToken}")
    public CommonResponse<?> select(@PathVariable("rootToken") String rootToken) {
        RootInfo.Main rootInfo = rootFacade.select(rootToken);
        RootDto.Main response = rootDtoMapper.of(rootInfo);
        return CommonResponse.success(response);
    }


}
