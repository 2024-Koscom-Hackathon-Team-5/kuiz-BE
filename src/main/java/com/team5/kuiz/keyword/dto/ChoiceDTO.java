package com.team5.kuiz.keyword.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChoiceDTO {

    private Long id;
    private String quiz_name;
    private String choice_num;
    private String choice;
    private Boolean isAnswer;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

}
