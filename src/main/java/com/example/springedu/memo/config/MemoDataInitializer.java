package com.example.springedu.memo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springedu.memo.repository.MemoRepository;
import com.example.springedu.memo.service.Memo;

@Configuration
public class MemoDataInitializer {

    @Bean
    CommandLineRunner initDatabase(MemoRepository memoRepository) {
        return args -> {
            memoRepository.save(Memo.builder()
                    .memoTitle("첫 번째 메모")
                    .memoContent("이것은 더미 메모 내용입니다.")
                    .writer("홍길동")
                    .build());

            memoRepository.save(Memo.builder()
                    .memoTitle("두 번째 메모")
                    .memoContent("두 번째 더미 메모 내용입니다.")
                    .writer("익명")
                    .build());

            memoRepository.save(Memo.builder()
                    .memoTitle(null) // 제목없음으로 자동 처리됨
                    .memoContent("제목 없는 메모")
                    .writer(null) // 익명으로 자동 처리됨
                    .build());
        };
    }
}
