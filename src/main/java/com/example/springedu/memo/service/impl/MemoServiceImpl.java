package com.example.springedu.memo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springedu.memo.repository.MemoRepository;
import com.example.springedu.memo.service.Memo;
import com.example.springedu.memo.service.MemoService;

@Service
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;

    public MemoServiceImpl(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    @Override
    public Memo saveMemo(Memo memo) {
        return memoRepository.save(memo);
    }

    @Override
    public List<Memo> getAllMemos() {
        return memoRepository.findAll();
    }

    @Override
    public Memo getMemo(Long id) {
        return memoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }
}

