package com.team5.kuiz.keyword.service;

import com.team5.kuiz.keyword.dto.ChatCompletionDTO;
import com.team5.kuiz.keyword.dto.CompletionDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface ChatGPTService {

    List<Map<String, Object>> modelList();

    Map<String, Object> isValidModel(String modelName);

    Map<String, Object> legacyPrompt(CompletionDTO completionDto);

    Map<String, Object> prompt(ChatCompletionDTO chatCompletionDto);

}
