package com.team5.kuiz.keyword.service;

import com.team5.kuiz.common.error.exception.EntityNotFoundException;
import com.team5.kuiz.keyword.domain.Choice;
import com.team5.kuiz.keyword.domain.Quiz;
import com.team5.kuiz.keyword.dto.ChoiceDTO;
import com.team5.kuiz.keyword.dto.KeywordDTO;
import com.team5.kuiz.keyword.dto.QuizDTO;
import com.team5.kuiz.keyword.repository.ChoiceRepository;
import com.team5.kuiz.keyword.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    @Override
    public List<QuizDTO> getQuizListbyQuiz() {
        return null;
    }

    @Override
    public QuizDTO getQuizByQuizId(Long quiz_id) {
        return null;
    }

    @Override
    public List<QuizDTO> getQuizListByKeyword_id(Long keyword_id) {
        Optional<List<Quiz>> quizListByKeyword_id = quizRepository.findQuizListByKeyword_id(keyword_id);
        if (!quizListByKeyword_id.isPresent()) {
            throw new EntityNotFoundException(keyword_id.toString());
        }
        List<Quiz> quizList = quizListByKeyword_id.get();

        List<QuizDTO> collect = quizList.stream()
                .map(quiz -> QuizDTO.builder()
                        .id(quiz.getId())
                        .quiz_name(quiz.getQuiz_name())
                        .choice_num(quiz.getChoice_num())
                        .answer(quiz.getAnswer())
                        .commentary(quiz.getCommentary())
                        .build())
                .collect(Collectors.toList());

        return collect;

    }

}
