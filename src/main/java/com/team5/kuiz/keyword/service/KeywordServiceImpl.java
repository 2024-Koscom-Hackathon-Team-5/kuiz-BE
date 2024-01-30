package com.team5.kuiz.keyword.service;

import com.team5.kuiz.common.error.exception.EntityNotFoundException;
import com.team5.kuiz.keyword.domain.Keyword;
import com.team5.kuiz.keyword.dto.KeywordDTO;
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
public class KeywordServiceImpl implements KeywordService {

    private final KeywordRepository keywordRepository;

    @Override
    public List<KeywordDTO> getKeywordsByKeywordName(String keyword_name) {
        return null;
    }

    @Override
    public List<KeywordDTO> getAllKeyword() {
        List<Keyword> all = keywordRepository.findAll();

        List<KeywordDTO> collect = all.stream()
                .map(keyword -> KeywordDTO.builder()
                        .keywordId(keyword.getId())
                        .quiz_phrase(keyword.getQuiz_phrase())
                        .kor_name(keyword.getKor_name())
                        .keyword_name(keyword.getKeyword_name())
                        .recommend_phrase(keyword.getRecommend_phrase())
                        .relavant_product(keyword.getRelavant_product())
                        .quiz_cnt(keyword.getQuiz_cnt())
                        .product_cnt(keyword.getProduct_cnt())
                        .createdDate(keyword.getCreatedDate())
                        .modifiedDate(keyword.getModifiedDate())
                        .build()).collect(Collectors.toList());

        return collect;
    }

    @Override
    public KeywordDTO getKeywordByKeywordId(Long keyword_id) {
        Optional<Keyword> keywordByKeywordId = keywordRepository.findKeywordByKeyword_id(keyword_id);
        if (!keywordByKeywordId.isPresent()) {
            throw new EntityNotFoundException(keyword_id.toString());
        }
        Keyword byKeywordName = keywordByKeywordId.get();
        KeywordDTO keywordDTO = KeywordDTO.builder()
                .keywordId(byKeywordName.getId())
                .quiz_phrase(byKeywordName.getQuiz_phrase())
                .kor_name(byKeywordName.getKor_name())
                .keyword_name(byKeywordName.getKeyword_name())
                .recommend_phrase(byKeywordName.getRecommend_phrase())
                .relavant_product(byKeywordName.getRelavant_product())
                .quiz_cnt(byKeywordName.getQuiz_cnt())
                .product_cnt(byKeywordName.getProduct_cnt())
                .createdDate(byKeywordName.getCreatedDate())
                .modifiedDate(byKeywordName.getModifiedDate())
                .build();

        return keywordDTO;
    }

    @Override
    public KeywordDTO getKeywordByKeywordName(String keyword_name) {
        Optional<Keyword> optionalKeyword = keywordRepository.findByKeyword_name(keyword_name);
        if (!optionalKeyword.isPresent()) {
            throw new EntityNotFoundException(keyword_name);
        }
        Keyword byKeywordName = optionalKeyword.get();
        KeywordDTO keywordDTO = KeywordDTO.builder()
                .keywordId(byKeywordName.getId())
                .quiz_phrase(byKeywordName.getQuiz_phrase())
                .kor_name(byKeywordName.getKor_name())
                .keyword_name(byKeywordName.getKeyword_name())
                .recommend_phrase(byKeywordName.getRecommend_phrase())
                .relavant_product(byKeywordName.getRelavant_product())
                .quiz_cnt(byKeywordName.getQuiz_cnt())
                .product_cnt(byKeywordName.getProduct_cnt())
                .createdDate(byKeywordName.getCreatedDate())
                .modifiedDate(byKeywordName.getModifiedDate())
                .build();

        return keywordDTO;
    }

}
