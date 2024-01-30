package com.team5.kuiz.keyword.service;


import com.team5.kuiz.keyword.dto.ChoiceDTO;
import com.team5.kuiz.keyword.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProductListByKeyword_id(Long keyword_id);
    List<ProductDTO> getProductListByStudent_id(Long student_id);
    List<ProductDTO> getProductListByStudent_idAndKeyword_id(Long student_id, Long keyword_id);

}
