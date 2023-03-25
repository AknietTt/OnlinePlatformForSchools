package com.example.Subject.controller;

import com.example.Subject.DTO.DirectorDTO;
import com.example.Subject.DTO.Response.DirectorResponseDTO;
import com.example.Subject.service.Users.DirectorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
public class DirectorController {
    private final DirectorService directorService;
    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/getAll")
    public List<DirectorDTO> getAll(){
        return directorService.getAll();
    }

    @GetMapping("/getByName/{firstName}/{lastName}")
    public ResponseEntity<List<DirectorResponseDTO>> getByName(
            @PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){
        if(directorService.getByName(firstName,lastName).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(directorService.getByName(firstName,lastName));
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid DirectorDTO directorDTO , BindingResult bindingResult){
         if (bindingResult.hasErrors() || !directorService.add(directorDTO)){
            return ResponseEntity.badRequest().build();
         }
         return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
       if(!directorService.deleteById(id)){
            return ResponseEntity.notFound().build();
       }
         return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateById(
            @PathVariable("id") int id, @RequestBody @Valid DirectorDTO directorDTO, BindingResult bindingResult){

        if(!directorService.updateById(directorDTO,id) ){
            return ResponseEntity.notFound().build();
        }
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
