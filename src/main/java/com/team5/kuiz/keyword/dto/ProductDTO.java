package com.team5.kuiz.keyword.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String product_name;
    private String firm;
    private Long period;
    private Double interest_max;
    private Double interest_min;
    private String product_url;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

}
