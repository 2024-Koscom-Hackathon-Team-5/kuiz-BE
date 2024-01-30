package com.team5.kuiz.keyword.service;


import com.team5.kuiz.keyword.dto.ChoiceDTO;
import com.team5.kuiz.keyword.dto.KeywordDTO;
import com.team5.kuiz.keyword.dto.QuizDTO;

import java.util.List;

public interface ChoiceService {
    List<ChoiceDTO> getChoiceListbyQuiz_id(Long quiz_id, String quiz_name);

}
