package com.team5.kuiz.keyword.service;


import com.team5.kuiz.keyword.domain.Ownership;
import com.team5.kuiz.keyword.dto.KeywordDTO;
import com.team5.kuiz.keyword.dto.OwnershipDTO;

import java.util.List;

public interface OwnershipService {
    List<Ownership> getOwnershipListByStudentId(Long student_id);

}
