package com.example.Subject.controller;

import com.example.Subject.DTO.Response.SubjectResponse;
import com.example.Subject.model.Subjects.Subject;
import com.example.Subject.service.Subjects.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/getAll")
    public List<Subject> getAll(){
        return subjectService.getAll();
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<SubjectResponse> getByName(@PathVariable("name") String subjectName){
        return ResponseEntity.ok(subjectService.getByName(subjectName));
    }


}
