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
public class StudentDTO {

    private Long student_id;
    private String name;
    private Long age;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

}
