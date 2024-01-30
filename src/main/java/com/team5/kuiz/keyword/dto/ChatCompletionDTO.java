package com.team5.kuiz.keyword.dto;

import lombok.*;

import java.util.List;
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatCompletionDTO {

    // 사용할 모델
    private String model;

    private List<ChatRequestMsgDTO> messages;

    @Builder
    public ChatCompletionDTO(String model, List<ChatRequestMsgDTO> messages) {
        this.model = model;
        this.messages = messages;
    }
}
