package me.hbchae.notice_board.controller;

import lombok.RequiredArgsConstructor;
import me.hbchae.notice_board.domain.Notice;
import me.hbchae.notice_board.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/notices")
    public String list(@PageableDefault Pageable pageable, Model model) {
        Page<Notice> boardList = noticeService.findNotices(pageable);
        boardList.stream().forEach(e -> e.getContent());
        model.addAttribute("boardList", boardList);
        return "/notices/noticeList";
    }

    @PostMapping("/notices/new")
    public String create(@RequestParam("memberId") Long memberId,
                         @RequestParam("title") String title,
                         @RequestParam("content") String content) {
        noticeService.createNotice(memberId,title,content);
        return "redirect:/notices";

    }
}
