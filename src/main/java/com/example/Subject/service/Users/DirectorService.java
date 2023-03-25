package com.example.Subject.service.Users;
import com.example.Subject.DTO.DirectorDTO;
import com.example.Subject.DTO.Response.DirectorResponseDTO;
import com.example.Subject.model.Users.Director;
import com.example.Subject.repository.Users.DirectorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DirectorService {
    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<DirectorDTO> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        TypeToken<List<DirectorDTO>> typeToken = new TypeToken<List<DirectorDTO>>() {};

        Type listType = new TypeToken<List<Director>>() {}.getType();
        List<Director> directors = directorRepository.findAll();
        List<DirectorDTO> result = modelMapper.map(directors, typeToken.getType());
        return result;
    }

    public List<DirectorResponseDTO> getByName(String firstName, String lastName) {
        ModelMapper modelMapper = new ModelMapper();
        TypeToken<List<DirectorResponseDTO>> typeToken = new TypeToken<List<DirectorResponseDTO>>() {};

        Type listType = new TypeToken<List<Director>>() {}.getType();
        List<Director> directors = directorRepository.findByFirstNameOrLastName(firstName,lastName);
        List<DirectorResponseDTO> result = modelMapper.map(directors, typeToken.getType());

        return result;
    }
    @Transactional
    public boolean add(DirectorDTO directorDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Director res = modelMapper.map(directorDTO, Director.class);
            directorRepository.save(res);
            return true;
        }catch (DataAccessException ex){
            return false;
        }

    }
    @Transactional
    public boolean deleteById(int id) {
        try {
            directorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public boolean updateById( DirectorDTO directorDTO,int id){
        Optional<Director> entityOptional = directorRepository.findById(id);
        if (entityOptional.isPresent()){
            try{
                Director result = entityOptional.get();
                result.setEmail(directorDTO.getEmail());
                result.setFirstName(directorDTO.getFirstName());
                result.setLastName(directorDTO.getLastName());
                directorRepository.save(result);
                return true;
            }catch (Exception ex){
                return false;
            }
        }
        return false;
    }
}
