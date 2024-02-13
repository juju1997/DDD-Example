package com.example.ddd.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.flywaydb.core.api.ErrorCode;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private Result result;
    private T data;
    private String message;
    private String errorCode;

    public static <T> CommonResponse<T> success() {
        return CommonResponse.success(null);
    }

    public static <T> CommonResponse<T> success(T data) {
        return CommonResponse.success(data, null);
    }

    public static <T> CommonResponse<T> success(T data, String message) {
        return CommonResponse.<T>builder()
                .result(Result.SUCCESS)
                .data(data)
                .message(message)
                .build();
    }

    public static CommonResponse<?> fail(String message, String errorCode) {
        return CommonResponse.builder()
                .result(Result.ERROR)
                .message(message)
                .errorCode(errorCode)
                .build();
    }

    public static CommonResponse<?> fail(CommonError error) {
        return CommonResponse.builder()
                .result(Result.ERROR)
                .message(error.getErrorMsg())
                .errorCode(error.name())
                .build();
    }

    public enum Result {
        SUCCESS,
        ERROR
    }
}