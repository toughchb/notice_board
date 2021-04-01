package me.hbchae.notice_board.repository;

import me.hbchae.notice_board.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
