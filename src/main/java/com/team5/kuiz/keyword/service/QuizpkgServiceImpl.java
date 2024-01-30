package com.team5.kuiz.keyword.service;

import com.team5.kuiz.common.error.exception.EntityNotFoundException;
import com.team5.kuiz.keyword.domain.Keyword;
import com.team5.kuiz.keyword.domain.Product;
import com.team5.kuiz.keyword.domain.Quizpkg;
import com.team5.kuiz.keyword.dto.KeywordDTO;
import com.team5.kuiz.keyword.dto.ProductDTO;
import com.team5.kuiz.keyword.dto.QuizpkgDTO;
import com.team5.kuiz.keyword.repository.ProductRepository;
import com.team5.kuiz.keyword.repository.QuizpkgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class QuizpkgServiceImpl implements QuizpkgService {

    private final QuizpkgRepository quizpkgRepository;

    @Override
    public List<QuizpkgDTO> getAllQuizPkg() {
        List<Quizpkg> allQuizpkg = quizpkgRepository.findAll();

        List<QuizpkgDTO> collect = allQuizpkg.stream()
                .map(quizPkg -> QuizpkgDTO.builder()
                        .id(quizPkg.getId())
                        .pkg_name(quizPkg.getPkg_name())
                        .build()).collect(Collectors.toList());

        return collect;
    }
}
