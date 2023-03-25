package com.example.Subject.service.Users;


import com.example.Subject.DTO.Response.SpecializationResponseDTO;
import com.example.Subject.DTO.SpecializationDTO;
import com.example.Subject.model.Users.Specialization;
import com.example.Subject.repository.Users.SpecializationRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class SpecializationService {
    private final SpecializationRepository specializationRepository;

    @Autowired
    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    public List<SpecializationDTO> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        TypeToken<List<SpecializationDTO>> typeToken = new TypeToken<List<SpecializationDTO>>() {};

        Type listType = new TypeToken<List<Specialization>>() {}.getType();
        List<Specialization> specializations = specializationRepository.findAll();
        List<SpecializationDTO> result = modelMapper.map(specializations, typeToken.getType());
        return  result;

    }

    public boolean add(SpecializationDTO specializationDTO) {
        try {
            ModelMapper mapper = new ModelMapper();
            Specialization res =  mapper.map(specializationDTO, Specialization.class);
            specializationRepository.save(res);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public List<SpecializationResponseDTO> findByName(String name) {
        ModelMapper modelMapper = new ModelMapper();
        TypeToken<List<SpecializationResponseDTO>> typeToken = new TypeToken<List<SpecializationResponseDTO>>() {};

        Type listType = new TypeToken<List<Specialization>>() {}.getType();
        List<Specialization> specializations = specializationRepository.findByName(name);
        List<SpecializationResponseDTO> result = modelMapper.map(specializations, typeToken.getType());
        return  result;

    }
}
