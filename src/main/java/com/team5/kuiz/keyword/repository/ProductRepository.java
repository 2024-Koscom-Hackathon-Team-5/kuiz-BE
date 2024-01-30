package com.team5.kuiz.keyword.repository;

import com.team5.kuiz.keyword.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value=
            "SELECT * " +
                    "from kuiz.product p " +
                    "where p.keyword_id = :keyword_id"
            , nativeQuery = true)
    Optional<List<Product>> findProductListByKeyword_id(Long keyword_id);



    @Query(value=
            "SELECT * " +
                    "from kuiz.product p " +
                    "where p.student_id = :student_id"
            , nativeQuery = true)
    Optional<List<Product>> findProductListByStudent_id(Long student_id);

    @Query(value=
            "SELECT * " +
                    "from kuiz.product p " +
                    "where p.student_id = :student_id and p.keyword_id = :keyword_id"
            , nativeQuery = true)
    Optional<List<Product>> findProductListByStudent_idAndKeyword_id(Long student_id, Long keyword_id);

}

