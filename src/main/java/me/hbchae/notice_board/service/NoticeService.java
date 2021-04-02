package me.hbchae.notice_board.service;

import lombok.RequiredArgsConstructor;
import me.hbchae.notice_board.domain.Member;
import me.hbchae.notice_board.domain.Notice;
import me.hbchae.notice_board.repository.MemberRepository;
import me.hbchae.notice_board.repository.NoticeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoticeService {

    private final MemberRepository memberRepository;
    private final NoticeRepository noticeRepository;

    /***
     *  Create Notice
     */
    public Long createNotice(Long memberId, String title, String content) {
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("no such data"));
        Notice notice = new Notice(title, content, findMember);
        noticeRepository.save(notice);
        return notice.getId();
    }

    public void deleteNotice(Long noticeId) {
        Notice findNotice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> new IllegalArgumentException("no such data"));
        noticeRepository.delete(findNotice);
    }

    public Page<Notice> findNotices(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC, "createdDate")
        );
        return noticeRepository.findAll(pageRequest);
    }




}
