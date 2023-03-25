package com.example.Subject.controller;

import com.example.Subject.DTO.ParentDTO;
import com.example.Subject.DTO.Response.ParentResponseDTO;
import com.example.Subject.service.Users.ParentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parent")
public class ParentController {
    private final ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/getAll")
    public List<ParentDTO> getAll(){
        return parentService.getAll();
    }

    @GetMapping("/getByName/{firstName}/{lastName}")
    public ResponseEntity<List<ParentResponseDTO>> getByName(
            @PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){

        if(parentService.getByName(firstName,lastName).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(parentService.getByName(firstName,lastName));
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody ParentDTO parentDTO){
       if( !parentService.add(parentDTO)){
            return ResponseEntity.badRequest().build();
       }
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PatchMapping("/update/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid ParentDTO parentDTO, @PathVariable("id") int id){
        if(!parentService.update(parentDTO,id) ){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(
            @PathVariable("id") int id){

        if( parentService.deleteById(id) ){
           return ResponseEntity.ok(HttpStatus.OK);
       }return ResponseEntity.badRequest().build();
    }
}
