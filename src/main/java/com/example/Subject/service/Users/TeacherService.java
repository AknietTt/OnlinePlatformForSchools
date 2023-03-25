package com.example.Subject.service.Users;

import com.example.Subject.DTO.Response.TeacherResponseDTO;
import com.example.Subject.DTO.TeacherDTO;
import com.example.Subject.model.Users.Teacher;
import com.example.Subject.repository.Users.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherDTO> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        TypeToken<List<TeacherDTO>> typeToken = new TypeToken<List<TeacherDTO>>() {};

        Type listType = new TypeToken<List<Teacher>>() {}.getType();
        List<Teacher> teachers = teacherRepository.findAll();
        List<TeacherDTO> result = modelMapper.map(teachers, typeToken.getType());
        return  result;
    }

    public List<TeacherResponseDTO> getByName(String firstName, String lastName) {
        ModelMapper modelMapper = new ModelMapper();
        TypeToken<List<TeacherResponseDTO>> typeToken = new TypeToken<List<TeacherResponseDTO>>() {};

        Type listType = new TypeToken<List<Teacher>>() {}.getType();
        List<Teacher> teachers = teacherRepository.findByFirstNameOrLastName(firstName,lastName);
        List<TeacherResponseDTO> result = modelMapper.map(teachers, typeToken.getType());
        return  result;
    }

    public boolean add(TeacherDTO teacherDTO) {
        try {
            ModelMapper mapper = new ModelMapper();
            Teacher res =  mapper.map(teacherDTO, Teacher.class);
            teacherRepository.save(res);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean deleteById(int id) {
        try {
            teacherRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
