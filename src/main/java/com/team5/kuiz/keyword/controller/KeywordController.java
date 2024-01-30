package com.team5.kuiz.keyword.controller;

import com.team5.kuiz.keyword.domain.Keyword;
import com.team5.kuiz.keyword.domain.Ownership;
import com.team5.kuiz.keyword.dto.*;
import com.team5.kuiz.keyword.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("api")
public class KeywordController {

    private final KeywordServiceImpl keywordService;
    private final ChoiceServiceImpl choiceService;
    private final QuizServiceImpl quizService;
    private final ProductServiceImpl productService;
    private final QuizpkgServiceImpl quizpkgService;
    private final OwnershipService ownershipService;
    private final StudentService studentService;

//    @GetMapping("/{keyword_name}")
//    public ResponseEntity<Map<String, Object>> getKeywordInfo(@PathVariable(value = "keyword_name") String keyword_name) {
//        KeywordDTO keywordByName = keywordService.getKeywordByKeywordName(keyword_name);
//
//        HashMap<String, Object> resultMap = new HashMap<>();
//
//        resultMap.put("keyword_name", keyword_name);
//        resultMap.put("keyword_info", keywordByName);
//
//        return ResponseEntity.ok().body(resultMap);
//    }

    @GetMapping("/student")
    public ResponseEntity<Map<String, Object>> getStudent(
            @RequestParam("student_id") Long student_id
    ) {
        StudentDTO studentByStudentId = studentService.getStudentByStudent_id(student_id);

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("student", studentByStudentId);

        return ResponseEntity.ok().body(resultMap);
    }

    @GetMapping("/kuiz")
    public ResponseEntity<Map<String, Object>> getKuiz(
            @RequestParam("keyword") String keyword_name
    ) {
        KeywordDTO keyword = keywordService.getKeywordByKeywordName(keyword_name);
        List<QuizDTO> tempQuizList = quizService.getQuizListByKeyword_id(keyword.getKeywordId());
        List<QuizDTO> quizList = new ArrayList<>();

        for (QuizDTO q : tempQuizList){
            List<ChoiceDTO> choiceListbyQuizId = choiceService.getChoiceListbyQuiz_id(q.getId(),q.getQuiz_name());
            q.setChoices(choiceListbyQuizId);
            quizList.add(q);
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("keyword", keyword);
        resultMap.put("quiz_list", tempQuizList);

        return ResponseEntity.ok().body(resultMap);
    }

    @GetMapping("/ownership")
    public ResponseEntity<Map<String, Object>> getOwnership(
            @RequestParam("student_id") Long student_id
    ) {

        HashMap<String, Object> resultMap = new HashMap<>();
        List<OwnershipDTO> keyword_list = new ArrayList<>();

        List<Ownership> ownershipListByStudentId = ownershipService.getOwnershipListByStudentId(student_id);
        for (Ownership ownership : ownershipListByStudentId) {
            KeywordDTO keywordByKeywordId = keywordService.getKeywordByKeywordId(ownership.getKeyword().getId());
            Keyword keyword = ownership.getKeyword();
            List<ProductDTO> productList = productService.getProductListByStudent_idAndKeyword_id(student_id, keyword.getId());

            OwnershipDTO ownershipDTO = OwnershipDTO.builder()
                    .keyword(keywordByKeywordId)
                    .productDTOList(productList).build();
            keyword_list.add(ownershipDTO);
        }
        resultMap.put("keyword_list", keyword_list);

        return ResponseEntity.ok().body(resultMap);
    }

    @GetMapping("/product")
    public ResponseEntity<Map<String, Object>> getProductList(
            @RequestParam("keyword") String keyword_name
    ) {

        KeywordDTO keyword = keywordService.getKeywordByKeywordName(keyword_name);
        List<ProductDTO> productList = productService.getProductListByKeyword_id(keyword.getKeywordId());

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("keyword", keyword);
        resultMap.put("product_list", productList);

        return ResponseEntity.ok().body(resultMap);
    }

    @GetMapping("/keywords")
    public ResponseEntity<Map<String, Object>> getKeywordList() {
        List<KeywordDTO> allKeyword = keywordService.getAllKeyword();

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("keyword_list", allKeyword);

        return ResponseEntity.ok().body(resultMap);
    }

    @GetMapping("/quizpkg")
    public ResponseEntity<Map<String, Object>> getQuizpkgList() {
        List<QuizpkgDTO> allQuizPkg = quizpkgService.getAllQuizPkg();

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("quiz_package_list", allQuizPkg);

        return ResponseEntity.ok().body(resultMap);
    }
}
