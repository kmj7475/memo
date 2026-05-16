package com.example.springedu.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springedu.memo.service.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
