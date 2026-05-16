package com.example.springedu.memo.service;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "memo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memo_seq")
	@SequenceGenerator(name = "memo_seq", sequenceName = "memo_seq", allocationSize = 1)
	private Long memoNo;

    @Column(nullable = true)
    private String memoTitle;

    @Column(nullable = false)
    private String memoContent;

    @Column(updatable = false)
    private LocalDateTime createdDate;

    private String writer;

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
        if (this.memoTitle == null || this.memoTitle.isBlank()) {
            this.memoTitle = "제목없음";
        }
        if (this.writer == null || this.writer.isBlank()) {
            this.writer = "익명";
        }
    }
}

