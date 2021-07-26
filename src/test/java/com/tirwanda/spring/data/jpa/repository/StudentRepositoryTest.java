package com.tirwanda.spring.data.jpa.repository;

import com.tirwanda.spring.data.jpa.entity.Guardian;
import com.tirwanda.spring.data.jpa.entity.Student;
import org.assertj.core.api.Assertions;
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
                //.guardianName("Djoko")
                //.guardianEmail("djoko@gmail.com")
                //.guardianMobile("123456")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void createStudentGuardian() {
        Guardian guardian = Guardian.builder()
                .name("umi")
                .email("umi@gmail.com")
                .mobile("12323")
                .build();

        Student student = Student.builder()
                .firstName("Dwi")
                .lastName("Tirwanda")
                .email("dwi@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Student : " + studentList);
    }

    @Test
    public void showStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Dwi");
        System.out.println("Students : " + students);
    }

    @Test
    public void showStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("Dwi");
        System.out.println("Students : " + students);
    }

    @Test
    public void showStudentByLastNameNotNull() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("Students : " + students);
    }

    @Test
    public void showStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Djoko");
        System.out.println("Students : " + students);
    }

    @Test
    public void showStudentByFirstNameAndLastName() {
        List<Student> students = studentRepository.findByFirstNameAndLastName("Edho", "Tirwanda");
        System.out.println("Students : " + students);
    }

    @Test
    public void getStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("edho@gmail.com");
        System.out.println("Student : " + student);
    }

    @Test
    public void getStudentFirstNameByEmailAddressTest() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("dwi@gmail.com");
        System.out.println("Firstname: " + firstName);
    }

    @Test
    public void getStudentByEmailAddressNativeTest() {
        Student student = studentRepository.getStudentByEmailAddressNative("edho@gmail.com");
        System.out.println("Student: " + student);
    }

    @Test
    public void getStudentByEmailAddressNativeNameParamTest() {
        Student student = studentRepository.getStudentByEmailAddressNativeNameParam("dwi@gmail.com");
        System.out.println("Student: " + student);
    }

    @Test
    public void updateStudentNameByEmailTest() {
        Integer result = studentRepository.updateStudentNameByEmail("Initial", "dwi@gmail.com");
        assertEquals(1, result);
    }

}