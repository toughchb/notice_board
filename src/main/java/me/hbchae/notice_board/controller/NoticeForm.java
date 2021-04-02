package me.hbchae.notice_board.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter @Builder
public class NoticeForm {
    private Long id;

    @NotEmpty(message = "공지 제목은 필수 입니다.")
    private String title;

    @NotEmpty(message = "공지 내용은 필수 입니다.")
    private String content;
}
