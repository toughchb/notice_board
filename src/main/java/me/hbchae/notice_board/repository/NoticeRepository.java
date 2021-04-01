package me.hbchae.notice_board.repository;

import me.hbchae.notice_board.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
