package com.team5.kuiz.keyword.repository;

import com.team5.kuiz.keyword.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    @Query(value=
            "SELECT * " +
                    "from kuiz.keyword k " +
                    "where k.keyword_name = :keyword_name"
            , nativeQuery = true)
    Optional<Keyword> findByKeyword_name(String keyword_name);

    @Query(value=
            "SELECT * " +
                    "from kuiz.keyword k " +
                    "where k.keyword_id = :keyword_id"
            , nativeQuery = true)
    Optional<Keyword> findKeywordByKeyword_id(Long keyword_id);
}

