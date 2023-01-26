package com.study.study_springboots.utils;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
    public String getUniqueSequence() {
        // 유니크아이디생성
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
