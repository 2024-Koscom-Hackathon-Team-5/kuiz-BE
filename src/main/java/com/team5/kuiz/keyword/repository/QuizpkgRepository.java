package com.team5.kuiz.keyword.repository;

import com.team5.kuiz.keyword.domain.Product;
import com.team5.kuiz.keyword.domain.Quizpkg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizpkgRepository extends JpaRepository<Quizpkg, Long> {


}

