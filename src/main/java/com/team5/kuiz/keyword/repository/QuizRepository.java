package com.team5.kuiz.keyword.repository;

import com.team5.kuiz.keyword.domain.Keyword;
import com.team5.kuiz.keyword.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query(value=
            "SELECT * " +
                    "from quiz q " +
                    "where q.quiz_id = :quiz_id"
            , nativeQuery = true)
    Optional<Quiz> findQuizByQuiz_id(Long quiz_id);

    @Query(value=
            "SELECT * " +
                    "from kuiz.quiz q " +
                    "where q.keyword_id = :keyword_id"
            , nativeQuery = true)
    Optional<List<Quiz>> findQuizListByKeyword_id(Long keyword_id);

}

