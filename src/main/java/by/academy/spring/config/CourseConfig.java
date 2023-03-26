package by.academy.spring.config;

import by.academy.spring.beans.Course;
import by.academy.spring.beans.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class CourseConfig {

    @Bean
    public Course lowPerformingStudentsCourse() {
        List<Student> lowPerformingStudents = getTestData().stream()
                .filter(student -> student.getAverageMark() < 5.0)
                .collect(Collectors.toList());
        return new Course("Java Course", lowPerformingStudents);
    }

    @Bean
    public Course highPerformingStudentsCourse() {
        List<Student> highPerformingStudents = getTestData().stream()
                .filter(student -> student.getAverageMark() > 5.0)
                .collect(Collectors.toList());
        return new Course("Java Course", highPerformingStudents);
    }

    @Bean
    public Course highestPerformingStudentCourse() {
        Optional<Student> highestPerformingStudent = getTestData().stream()
                .max(Comparator.comparingDouble(Student::getAverageMark));
        return highestPerformingStudent.map(student -> new Course("Java Course",
                List.of(student))).orElseGet(() -> new Course("Java Course", null));
    }

    @Bean
    public Course lowestPerformingStudentCourse() {
        Optional<Student> lowestPerformingStudent = getTestData().stream()
                .min(Comparator.comparingDouble(Student::getAverageMark));
        return lowestPerformingStudent.map(student -> new Course("Java Course",
                List.of(student))).orElseGet(() -> new Course("Java Course", null));
    }

    private List<Student> getTestData() {
        List<Student> students = new ArrayList<>();
        Course javaCourse = new Course("Java Course", students);

        Student student1 = new Student("Alice", "Smith",
                javaCourse, 10.0,
                Arrays.asList("Programming", "Algorithms", "Data Structures"));

        Student student2 = new Student("Bob", "Johnson",
                javaCourse, 4.7,
                Arrays.asList("Calculus", "Linear Algebra", "Statistics"));

        Student student3 = new Student("Charlie", "Brown",
                javaCourse, 5.7,
                Arrays.asList("Literature", "Writing", "Grammar"));

        Student student4 = new Student("David", "Lee",
                javaCourse, 4.2,
                Arrays.asList("Programming", "Algorithms", "Data Structures"));

        Student student5 = new Student("Emily", "Wang",
                javaCourse, 2.9,
                Arrays.asList("Calculus", "Linear Algebra", "Statistics"));

        Student student6 = new Student("Frank", "Chen",
                javaCourse, 8.5,
                Arrays.asList("Literature", "Writing", "Grammar"));

        Collections.addAll(students, student1, student2, student3,
                student4, student5, student6);
        return students;
    }
}