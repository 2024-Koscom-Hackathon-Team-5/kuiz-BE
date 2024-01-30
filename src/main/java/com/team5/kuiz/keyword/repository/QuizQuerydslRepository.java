package com.team5.kuiz.keyword.repository;//package com.jdong.studycafe.keyword.repository;
//
//import com.jdong.studycafe.beverages.domain.Beverage;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//import static com.jdong.studycafe.beverages.domain.QBeverage.beverage;
//import static com.jdong.studycafe.beverages.domain.QBeverageImage.beverageImage;
//
//@Repository
//@RequiredArgsConstructor
//public class QuizQuerydslRepository {
//
//    private final JPAQueryFactory jpaQueryFactory;
//
//    public List<Beverage> findBeverageById(Long id) {
//        return jpaQueryFactory
//                .selectFrom(beverage)
//                .leftJoin(beverage.beverageImage, beverageImage).fetchJoin()
//                .where(beverage.id.eq(id))
//                .fetch();
//    }
//
//}
