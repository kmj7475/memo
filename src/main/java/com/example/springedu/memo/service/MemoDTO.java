package com.example.springedu.memo.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

