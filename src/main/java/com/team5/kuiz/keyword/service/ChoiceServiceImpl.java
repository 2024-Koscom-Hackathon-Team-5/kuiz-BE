package com.team5.kuiz.keyword.service;

import com.team5.kuiz.common.error.exception.EntityNotFoundException;
import com.team5.kuiz.keyword.domain.Choice;
import com.team5.kuiz.keyword.domain.Keyword;
import com.team5.kuiz.keyword.dto.ChoiceDTO;
import com.team5.kuiz.keyword.dto.KeywordDTO;
import com.team5.kuiz.keyword.repository.ChoiceRepository;
import com.team5.kuiz.keyword.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ChoiceServiceImpl implements ChoiceService {

    private final ChoiceRepository choiceRepository;

    @Override
    public List<ChoiceDTO> getChoiceListbyQuiz_id(Long quiz_id, String quiz_name) {
        Optional<List<Choice>> choiceListByQuizId = choiceRepository.findChoiceListByQuiz_id(quiz_id);
        if (!choiceListByQuizId.isPresent()){
            throw new EntityNotFoundException(choiceListByQuizId.toString());
        }
        List<Choice> choices = choiceListByQuizId.get();
        List<ChoiceDTO> collect = choices.stream()
                .map(choice -> ChoiceDTO.builder()
                        .id(choice.getId())
                        .choice_num(choice.getChoice_number())
                        .choice(choice.getChoice())
                        .isAnswer(choice.getIsAnswer())
                        .quiz_name(quiz_name)
                        .build())
                .collect(Collectors.toList());

        return collect;
    }
}
