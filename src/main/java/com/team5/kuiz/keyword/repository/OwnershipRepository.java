package com.team5.kuiz.keyword.repository;

import com.team5.kuiz.keyword.domain.Keyword;
import com.team5.kuiz.keyword.domain.Ownership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnershipRepository extends JpaRepository<Ownership, Long> {

    @Query(value=
            "SELECT * " +
                    "from kuiz.ownership o " +
                    "where o.student_id = :student_id"
            , nativeQuery = true)
    Optional<List<Ownership>> findByStudent_id(Long student_id);

}

