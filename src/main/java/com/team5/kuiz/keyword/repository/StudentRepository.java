package com.team5.kuiz.keyword.repository;

import com.team5.kuiz.keyword.domain.Choice;
import com.team5.kuiz.keyword.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value=
            "SELECT * " +
                    "from kuiz.student c " +
                    "where c.student_id = :student_id"
            , nativeQuery = true)
    Optional<Student> findStudentByStudent_id(Long student_id);

}

