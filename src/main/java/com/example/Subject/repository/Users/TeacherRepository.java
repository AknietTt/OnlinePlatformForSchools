package com.example.Subject.repository.Users;

import com.example.Subject.model.Users.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    List<Teacher> findByFirstNameOrLastName(String firstName, String lastName);
}
