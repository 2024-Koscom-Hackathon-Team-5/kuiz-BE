package com.team5.kuiz.keyword.service;

import com.team5.kuiz.common.error.exception.EntityNotFoundException;
import com.team5.kuiz.keyword.domain.Keyword;
import com.team5.kuiz.keyword.domain.Ownership;
import com.team5.kuiz.keyword.dto.KeywordDTO;
import com.team5.kuiz.keyword.dto.OwnershipDTO;
import com.team5.kuiz.keyword.repository.KeywordRepository;
import com.team5.kuiz.keyword.repository.OwnershipRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class OwnershipServiceImpl implements OwnershipService {

    private final KeywordRepository keywordRepository;
    private final OwnershipRepository ownershipRepository;

    @Override
    public List<Ownership> getOwnershipListByStudentId(Long student_id) {
        Optional<List<Ownership>> byStudentId = ownershipRepository.findByStudent_id(student_id);
        if (!byStudentId.isPresent()) {
            throw new EntityNotFoundException(student_id.toString());
        }
        List<Ownership> ownerships = byStudentId.get();


        return ownerships;
    }
}
