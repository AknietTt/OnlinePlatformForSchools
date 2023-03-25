package com.example.Subject.controller;


import com.example.Subject.DTO.Response.SpecializationResponseDTO;
import com.example.Subject.DTO.SpecializationDTO;
import com.example.Subject.service.Users.SpecializationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/specialization")
public class SpecializationController {
    private final SpecializationService specializationService;
    @Autowired
    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @GetMapping("/getAll")
    public List<SpecializationDTO> getAll(){
        return specializationService.getAll();
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<SpecializationResponseDTO>> getByName(@PathVariable("name") String name){
        if(specializationService.findByName(name).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(specializationService.findByName(name));
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid SpecializationDTO specializationDTO){
        if( !specializationService.add(specializationDTO)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
