package com.team5.kuiz.keyword.domain;

import com.team5.kuiz.common.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@ToString
@Entity
public class Choice extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choice_id")
    private Long id;
    private String choice_number;
    private String choice;
    private Boolean isAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

}
