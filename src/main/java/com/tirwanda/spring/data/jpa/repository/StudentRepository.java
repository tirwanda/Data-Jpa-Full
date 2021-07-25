package com.tirwanda.spring.data.jpa.repository;

import com.tirwanda.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByLastNameNotNull();
    public List<Student> findByGuardianName(String guardianName);
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select s from Student s where s.email = ?1")
    public Student getStudentByEmailAddress(String email);

    @Query("select s.firstName from Student s where s.email = ?1")
    public String getStudentFirstNameByEmailAddress(String email);
}
