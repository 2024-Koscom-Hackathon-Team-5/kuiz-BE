package com.team5.kuiz.keyword.service;


import com.team5.kuiz.keyword.dto.KeywordDTO;
import com.team5.kuiz.keyword.dto.QuizDTO;

import java.util.List;

public interface QuizService {
    List<QuizDTO> getQuizListbyQuiz();

    QuizDTO getQuizByQuizId(Long quiz_id);

    List<QuizDTO> getQuizListByKeyword_id(Long keyword_id);
}
