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
public class Quizpkg extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizpkg_id")
    private Long id;
    private String pkg_name;
}
