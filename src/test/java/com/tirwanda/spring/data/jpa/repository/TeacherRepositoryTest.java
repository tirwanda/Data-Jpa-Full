package com.tirwanda.spring.data.jpa.repository;

import com.tirwanda.spring.data.jpa.entity.Course;
import com.tirwanda.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void createTeacherTest() {
        Course courseJavaCollection = Course.builder()
                .title("Java Collection")
                .credit(2)
                .build();

        Course courseJavaDasar = Course.builder()
                .title("Java Dasar")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Elon")
                .lastName("Musk")
                .courses(List.of(courseJavaCollection, courseJavaDasar))
                .build();

        teacherRepository.save(teacher);
    }

}