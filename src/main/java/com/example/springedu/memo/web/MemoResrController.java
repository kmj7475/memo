package com.example.springedu.memo.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springedu.memo.service.Memo;
import com.example.springedu.memo.service.MemoDTO;
import com.example.springedu.memo.service.MemoService;

@RestController
@RequestMapping("/api/memos")
public class MemoResrController {

    private final MemoService memoService;

    public MemoResrController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping
    public MemoDTO createMemo(@RequestBody MemoDTO memoDTO) {
        Memo memo = Memo.builder()
                .memoTitle(memoDTO.getMemoTitle())
                .memoContent(memoDTO.getMemoContent())
                .writer(memoDTO.getWriter())
                .build();

        Memo saved = memoService.saveMemo(memo);
        return toDTO(saved);
    }

    @GetMapping
    public List<MemoDTO> getMemos() {
        return memoService.getAllMemos()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MemoDTO getMemo(@PathVariable Long id) {
        Memo memo = memoService.getMemo(id);
        return memo != null ? toDTO(memo) : null;
    }

    @DeleteMapping("/{id}")
    public void deleteMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
    }

    private MemoDTO toDTO(Memo memo) {
        return MemoDTO.builder()
                .memoNo(memo.getMemoNo())
                .memoTitle(memo.getMemoTitle())
                .memoContent(memo.getMemoContent())
                .writer(memo.getWriter())
                .createdDate(memo.getCreatedDate().toString())
                .build();
    }
}

