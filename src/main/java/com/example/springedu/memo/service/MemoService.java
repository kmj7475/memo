package com.example.springedu.memo.service;


import java.util.List;

public interface MemoService {
    Memo saveMemo(Memo memo);
    List<Memo> getAllMemos();
    Memo getMemo(Long id);
    void deleteMemo(Long id);
}

