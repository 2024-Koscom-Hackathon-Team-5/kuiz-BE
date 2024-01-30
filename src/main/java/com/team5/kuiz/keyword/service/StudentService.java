package com.team5.kuiz.keyword.service;


import com.team5.kuiz.keyword.domain.Student;
import com.team5.kuiz.keyword.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO getStudentByStudent_id(Long student_id);
}
