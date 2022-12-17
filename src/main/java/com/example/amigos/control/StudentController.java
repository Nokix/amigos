package com.example.amigos.control;

import com.example.amigos.model.Student;
import com.example.amigos.model.StudentRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationNotFoundException;
import java.awt.*;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String sayHello() {
        return studentRepository.findAll().stream().map(Student::toString).collect(Collectors.joining("\n"));
    }

    @GetMapping(value = "/{id}", produces = "application/xml")
    public Optional<Student> getById(@PathVariable Long id) {
        return studentRepository.findById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public Student editStudent(@PathVariable Long id, @RequestBody Student student) throws RelationNotFoundException {
        System.out.println("Funktion 1");
        Student existingStudent = studentRepository.findById(id).orElseThrow(RelationNotFoundException::new);
        if (student.getFirstName() != null) existingStudent.setFirstName(student.getFirstName());
        return studentRepository.save(existingStudent);

    }
    @PutMapping(value = "/{id}", consumes = APPLICATION_XML_VALUE)
    public Student editStudent2(@PathVariable Long id, @RequestBody Student student) throws RelationNotFoundException {
        System.out.println("Funktion 2");
        Student existingStudent = studentRepository.findById(id).orElseThrow(RelationNotFoundException::new);
        if (student.getFirstName() != null) existingStudent.setFirstName(student.getFirstName());
        return studentRepository.save(existingStudent);
    }
}
