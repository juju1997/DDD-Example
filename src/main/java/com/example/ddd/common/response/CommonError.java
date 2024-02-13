package com.example.ddd.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonError {

    SYSTEM_ERROR("시스템의 문제 발생"),
    INVALID_PARAMETER("요청 값 오류");

    private final String errorMsg;

}
