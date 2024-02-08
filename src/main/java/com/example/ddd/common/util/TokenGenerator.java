package com.example.ddd.common.util;

import com.fasterxml.uuid.Generators;

/**
 * TokenGenerator
 * */
public class TokenGenerator {

    /**
     *  UUID7 사용
     *  UUID7 은 Timebased로 인덱싱에 용이하여 선택
     * */
    public static String generateToken() {
        return Generators.timeBasedEpochGenerator().generate().toString();
    }

    /**
     *  Prefix + generateToken()
     * */
    public static String generateTokenWithPrefix(String prefix) {
        return prefix + generateToken();
    }

}
