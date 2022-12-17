package com.example.amigos;

import com.example.amigos.model.Student;
import com.example.amigos.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
//@Api(value = "Example Controller")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
//    @ApiOperation(value = "Say Hello")
    public String sayHello() {
        return studentRepository.findAll().stream().map(Student::toString).collect(Collectors.joining("\n"));
    }
}
