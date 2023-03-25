package com.example.Subject.service.Subjects;

import com.example.Subject.DTO.Response.SubjectResponse;
import com.example.Subject.model.Subjects.Subject;
import com.example.Subject.repository.Subjects.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAll() {
       return subjectRepository.findAll();
    }

    public SubjectResponse getByName(String subjectName) {
        Subject subject = subjectRepository.findByNameRu(subjectName);
        ModelMapper modelMapper = new ModelMapper();
        SubjectResponse subjectResponse = modelMapper.map(subject,SubjectResponse.class);
        return  subjectResponse;
    }
}
