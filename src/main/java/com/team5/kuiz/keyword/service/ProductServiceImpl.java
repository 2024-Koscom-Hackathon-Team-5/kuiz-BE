package com.team5.kuiz.keyword.service;

import com.team5.kuiz.common.error.exception.EntityNotFoundException;
import com.team5.kuiz.keyword.domain.Choice;
import com.team5.kuiz.keyword.domain.Product;
import com.team5.kuiz.keyword.dto.ChoiceDTO;
import com.team5.kuiz.keyword.dto.ProductDTO;
import com.team5.kuiz.keyword.repository.ChoiceRepository;
import com.team5.kuiz.keyword.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> getProductListByKeyword_id(Long keyword_id) {
        Optional<List<Product>> productListByKeywordId = productRepository.findProductListByKeyword_id(keyword_id);
        if(!productListByKeywordId.isPresent()){
            throw new EntityNotFoundException(keyword_id.toString());
        }
        List<Product> products = productListByKeywordId.get();
        List<ProductDTO> collect = products.stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .product_name(product.getProduct_name())
                        .firm(product.getFirm())
                        .period(product.getPeriod())
                        .interest_max(product.getInterest_max())
                        .interest_min(product.getInterest_min())
                        .product_url(product.getProduct_url())
                        .build())
                .collect(Collectors.toList());

        return collect;
    }

    @Override
    public List<ProductDTO> getProductListByStudent_id(Long student_id) {
        Optional<List<Product>> productListByStudent_id = productRepository.findProductListByStudent_id(student_id);
        if (!productListByStudent_id.isPresent()) {
            throw new EntityNotFoundException(student_id.toString());
        }
        List<Product> products = productListByStudent_id.get();
        List<ProductDTO> collect = products.stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .product_name(product.getProduct_name())
                        .firm(product.getFirm())
                        .period(product.getPeriod())
                        .interest_max(product.getInterest_max())
                        .interest_min(product.getInterest_min())
                        .product_url(product.getProduct_url())
                        .build())
                .collect(Collectors.toList());

        return collect;
    }

    @Override
    public List<ProductDTO> getProductListByStudent_idAndKeyword_id(Long student_id, Long keyword_id) {
        Optional<List<Product>> productListByStudentIdAndKeywordId = productRepository.findProductListByStudent_idAndKeyword_id(student_id, keyword_id);
        if (!productListByStudentIdAndKeywordId.isPresent()) {
            throw new EntityNotFoundException(productListByStudentIdAndKeywordId.toString());
        }
        List<Product> products = productListByStudentIdAndKeywordId.get();
        List<ProductDTO> collect = products.stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .product_name(product.getProduct_name())
                        .firm(product.getFirm())
                        .period(product.getPeriod())
                        .interest_max(product.getInterest_max())
                        .interest_min(product.getInterest_min())
                        .product_url(product.getProduct_url())
                        .build())
                .collect(Collectors.toList());

        return collect;
    }
}
