package com.team5.kuiz.keyword.service;

import com.team5.kuiz.common.error.exception.EntityNotFoundException;
import com.team5.kuiz.keyword.domain.Keyword;
import com.team5.kuiz.keyword.domain.Student;
import com.team5.kuiz.keyword.dto.KeywordDTO;
import com.team5.kuiz.keyword.dto.StudentDTO;
import com.team5.kuiz.keyword.repository.KeywordRepository;
import com.team5.kuiz.keyword.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public StudentDTO getStudentByStudent_id(Long student_id) {
        Optional<Student> studentByStudentId = studentRepository.findStudentByStudent_id(student_id);

        if (!studentByStudentId.isPresent()) {
            throw new EntityNotFoundException(student_id.toString());
        }
        Student student = studentByStudentId.get();
        StudentDTO studentDTO = StudentDTO.builder()
                .student_id(student.getId())
                .age(student.getAge())
                .name(student.getName()).build();

        return studentDTO;
    }
}
