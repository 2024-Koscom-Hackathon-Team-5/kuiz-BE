package com.team5.kuiz.keyword.domain;

import com.team5.kuiz.common.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@ToString
@Entity
public class Keyword extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id")
    private Long id;
    private String keyword_name;
    private String kor_name;
    private String relavant_product;
    private String recommend_phrase;
    private Long quiz_cnt;
    private Long product_cnt;
    private String quiz_phrase;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "keyword")
    private List<Product> products = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "keyword")
    private List<Quiz> quizs = new ArrayList<>();

}
