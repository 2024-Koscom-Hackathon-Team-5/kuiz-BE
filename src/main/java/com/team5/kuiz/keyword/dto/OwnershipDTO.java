package com.team5.kuiz.keyword.dto;

import com.team5.kuiz.keyword.domain.Keyword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnershipDTO {
    private KeywordDTO keyword;
    private List<ProductDTO> productDTOList;
}
