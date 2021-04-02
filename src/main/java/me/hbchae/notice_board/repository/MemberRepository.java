package me.hbchae.notice_board.repository;

import me.hbchae.notice_board.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {
    List<Member> findByName(String name);
}
