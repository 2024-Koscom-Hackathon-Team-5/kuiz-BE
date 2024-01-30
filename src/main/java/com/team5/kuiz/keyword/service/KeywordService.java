package com.team5.kuiz.keyword.service;


import com.team5.kuiz.keyword.domain.Keyword;
import com.team5.kuiz.keyword.dto.KeywordDTO;

import java.util.List;

public interface KeywordService {
    List<KeywordDTO> getKeywordsByKeywordName(String keyword_name);

    List<KeywordDTO> getAllKeyword();
    KeywordDTO getKeywordByKeywordId(Long keyword_id);
    KeywordDTO getKeywordByKeywordName(String keyword_name);
}
