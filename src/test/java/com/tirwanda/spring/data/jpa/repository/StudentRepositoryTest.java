package com.tirwanda.spring.data.jpa.repository;

import com.tirwanda.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void createStudent() {
        Student student = Student.builder()
                .email("edho@gmail.com")
                .firstName("Edho")
                .lastName("Tirwanda")
                .guardianName("Djoko")
                .guardianEmail("djoko@gmail.com")
                .guardianMobile("123456")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Student : " + studentList);
    }

}