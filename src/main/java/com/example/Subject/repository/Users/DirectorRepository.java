package com.example.Subject.repository.Users;

import com.example.Subject.model.Users.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {
    List<Director> findAll();
    List<Director> findByFirstNameOrLastName(String firstname, String lastname);

}
