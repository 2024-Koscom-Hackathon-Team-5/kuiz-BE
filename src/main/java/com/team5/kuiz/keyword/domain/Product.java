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
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String product_name;
    private String firm;
    private Long period;
    private Double interest_max;
    private Double interest_min;
    private String product_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keyword_id")
    private Keyword keyword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
}
