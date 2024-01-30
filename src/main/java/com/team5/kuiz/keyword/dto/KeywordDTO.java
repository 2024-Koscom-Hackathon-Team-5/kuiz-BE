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
public class KeywordDTO {

    private Long keywordId;
    private String keyword_name;
    private String kor_name;
    private String relavant_product;
    private String recommend_phrase;
    private Long quiz_cnt;
    private Long product_cnt;
    private String quiz_phrase;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

}
