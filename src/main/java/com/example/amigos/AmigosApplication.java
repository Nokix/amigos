package com.example.amigos;

import com.example.amigos.model.Student;
import com.example.amigos.model.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AmigosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmigosApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            studentRepository.save(new Student().setFirstName("Viktor"));
            studentRepository.save(new Student().setFirstName("Max"));
        };
    }

}
