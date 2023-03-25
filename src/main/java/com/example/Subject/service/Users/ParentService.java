package com.example.Subject.service.Users;


import com.example.Subject.DTO.ParentDTO;
import com.example.Subject.DTO.Response.ParentResponseDTO;
import com.example.Subject.model.Users.Parent;
import com.example.Subject.repository.Users.ParentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class ParentService {
    private final ParentRepository parentRepository;
    @Autowired
    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public List<ParentDTO> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        TypeToken<List<ParentDTO>> typeToken = new TypeToken<List<ParentDTO>>() {};

        Type listType = new TypeToken<List<Parent>>() {}.getType();
        List<Parent> parents = parentRepository.findAll();
        List<ParentDTO> result = modelMapper.map(parents, typeToken.getType());
        return  result;
    }

    public boolean add(ParentDTO parentDTO) {
        try {
            ModelMapper mapper = new ModelMapper();
            Parent res =  mapper.map(parentDTO, Parent.class);
            parentRepository.save(res);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public List<ParentResponseDTO> getByName(String firstName, String lastName) {
        ModelMapper modelMapper = new ModelMapper();
        TypeToken<List<ParentResponseDTO>> typeToken = new TypeToken<List<ParentResponseDTO>>() {};

        Type listType = new TypeToken<List<Parent>>() {}.getType();
        List<Parent> parents = parentRepository.findByFirstNameOrLastName(firstName,lastName);
        List<ParentResponseDTO> result = modelMapper.map(parents, typeToken.getType());
        return  result;
    }

    public boolean update(ParentDTO parentDTO, int id) {
        Optional<Parent> entityOptional = parentRepository.findById(id);

        if (entityOptional.isPresent()){
            try {
                Parent result = entityOptional.get();
                result.setEmail(parentDTO.getEmail());
                result.setFirstName(parentDTO.getFirstName());
                result.setLastName(parentDTO.getLastName());
                result.setPhone(parentDTO.getPhone());
                parentRepository.save(result);
                return true;
            }catch (Exception ex){
                return false;
            }
        }
        return false;
    }

    public boolean deleteById(int id) {
        try {
            parentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
