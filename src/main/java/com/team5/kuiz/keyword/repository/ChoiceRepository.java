package com.team5.kuiz.keyword.repository;

import com.team5.kuiz.keyword.domain.Choice;
import com.team5.kuiz.keyword.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {

    @Query(value=
            "SELECT * " +
                    "from kuiz.choice c " +
                    "where c.quiz_id = :quiz_id " +
                    "ORDER BY kuiz.choice.choice_num"
            , nativeQuery = true)
    Optional<List<Choice>> findChoiceListByQuiz_id(Long quiz_id);

}

