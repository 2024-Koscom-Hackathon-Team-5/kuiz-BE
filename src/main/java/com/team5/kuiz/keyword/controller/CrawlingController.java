package com.team5.kuiz.keyword.controller;

import com.team5.kuiz.keyword.dto.*;
import com.team5.kuiz.keyword.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/v1/chatGpt")
public class CrawlingController {

    private final ChatGPTService chatGPTService;

    @PostMapping("/crawling")
    public ResponseEntity<Map<String, Object>> selectPrompt(@RequestBody ChatCompletionDTO chatCompletionDto) {
        log.debug("param :: " + chatCompletionDto.toString());
        Map<String, Object> result = chatGPTService.prompt(chatCompletionDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
