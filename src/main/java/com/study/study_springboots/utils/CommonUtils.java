package com.study.study_springboots.utils;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
    public String getUniqueSequence() {
        // 유니크아이디생성
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    // "src/main/resources/static/files/" -> root directory + 상대경로
    public String getRelativeToAbsolutePath(String relativePath) {
        // 상대경로의 /을 \로 바꾸기
        String relativePathWithSeparator = relativePath.replace("/", File.separator);
        // 절대경로 찾아오기
        String absolutePath = new File(relativePathWithSeparator).getAbsolutePath() + File.separator;
        return absolutePath;

    }
}
