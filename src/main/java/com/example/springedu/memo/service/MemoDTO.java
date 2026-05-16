package com.example.springedu.memo.service;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemoDTO {
    private Long memoNo;
    private String memoTitle;
    private String memoContent;
    private String writer;
    private String createdDate;
}

