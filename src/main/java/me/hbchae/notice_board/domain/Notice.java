package me.hbchae.notice_board.domain;

import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
public class Notice {
    @Id
    @GeneratedValue
    @Column(name = "notice_id")
    private Long id;

    @Column(nullable = false, length = 255)
    private String content;


}
