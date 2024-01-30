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
public class Student extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    private String name;
    private Long age;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<Product> products = new ArrayList<>();
}
