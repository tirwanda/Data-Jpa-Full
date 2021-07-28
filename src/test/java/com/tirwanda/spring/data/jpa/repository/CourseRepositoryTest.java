package com.tirwanda.spring.data.jpa.repository;

import com.tirwanda.spring.data.jpa.entity.Course;
import com.tirwanda.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void showAllCoursesTest() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses : " + courses);
    }

    @Test
    public void createCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Jeff")
                .lastName("Bezos")
                .build();

        Course course = Course.builder()
                .title("Java Stream")
                .credit(4)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecord = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecord = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecord).getContent();
        Long totalElements = courseRepository.findAll(firstPageWithThreeRecord).getTotalElements();
        Integer totalPages = courseRepository.findAll(firstPageWithThreeRecord).getTotalPages();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc =
                PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0, 2, Sort.by("title").descending()
                .and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void findByTitleContainingTest() {
        Pageable firstPageTenRecord = PageRequest.of(0, 10);

        List<Course> courses =
                courseRepository.findByTitleContaining("Java", firstPageTenRecord).getContent();
        System.out.println("courses = " + courses);
    }

}