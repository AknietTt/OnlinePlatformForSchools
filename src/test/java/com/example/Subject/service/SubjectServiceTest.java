package com.example.Subject.service;
import com.example.Subject.DTO.Response.SubjectResponse;
import com.example.Subject.model.Subjects.Subject;
import com.example.Subject.repository.Subjects.SubjectRepository;
import com.example.Subject.service.Subjects.SubjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SubjectServiceTest {
    @InjectMocks
    private SubjectService subjectService;
    @Mock
    private  SubjectRepository subjectRepository;

    @Test
    public void shouldReturnSubjectInList(){
        List<Subject> subjectList = new ArrayList<>();

        subjectList.add(new Subject(1,"Математика",
                "Наука, изучающая математические структуры, свойства, их отношения и преобразования."));
        subjectList.add(new Subject(2,"Физика","Естественная наука, изучающая природу и ее явления."));
        Mockito.when(subjectRepository.findAll()).thenReturn(subjectList);

        List<Subject> result = subjectService.getAll();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.size(),2 );
    }
    @Test
    public void shouldReturnSubject(){
        Subject subject = new Subject(1,"Математика",
                "Наука, изучающая математические структуры, свойства, их отношения и преобразования.");
        Mockito.when(subjectRepository.findByNameRu("Математика")).thenReturn(subject);

        SubjectResponse result = subjectService.getByName(subject.getNameRu());
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getNameRu(),subject.getNameRu());
    }
}
