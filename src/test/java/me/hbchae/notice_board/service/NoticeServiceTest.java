package me.hbchae.notice_board.service;

import me.hbchae.notice_board.domain.Member;
import me.hbchae.notice_board.domain.Notice;
import me.hbchae.notice_board.repository.MemberRepository;
import me.hbchae.notice_board.repository.NoticeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class NoticeServiceTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    NoticeService noticeService;
    @Autowired
    NoticeRepository noticeRepository;
    @PersistenceContext
    EntityManager em;

    Long createdMemberId;

    @BeforeEach
    void createMember() {
        Member createMember = new Member("chae", "1234");
        createdMemberId = memberRepository.save(createMember).getId();
    }
    @Test
    void createNoticeTest() {
        Long notice = noticeService.createNotice(createdMemberId, "this is Test Title", "This is Test Content");
        em.flush();
        em.clear();
        Notice findNotice = noticeRepository.findById(notice).get();
        assertThat(findNotice.getTitle()).contains("this is Test Title");
    }

    @Test
    void page() {

    }
}