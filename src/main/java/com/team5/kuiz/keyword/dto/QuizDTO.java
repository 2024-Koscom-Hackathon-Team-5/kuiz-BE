package com.team5.kuiz.keyword.dto;

import com.team5.kuiz.keyword.domain.Choice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {

    private Long id;
    private String quiz_name;
    private Long choice_num;
    private String answer;
    private String commentary;
    private List<ChoiceDTO> choices;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

}
