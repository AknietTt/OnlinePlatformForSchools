package com.example.Subject.controller;

import com.example.Subject.DTO.Response.TeacherResponseDTO;
import com.example.Subject.DTO.TeacherDTO;
import com.example.Subject.service.Users.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TeacherDTO>> getAll(){
        return ResponseEntity.ok(teacherService.getAll());
    }

    @GetMapping("/getByName/{firstName}/{lastName}")
    public ResponseEntity<List<TeacherResponseDTO>> getByName(
              @PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){

        if(teacherService.getByName(firstName,lastName).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teacherService.getByName(firstName,lastName));
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody TeacherDTO teacherDTO){
        if( !teacherService.add(teacherDTO)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        if(!teacherService.deleteById(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
