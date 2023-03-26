package by.academy.spring;

import by.academy.spring.beans.Course;
import by.academy.spring.config.CourseConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CourseConfig.class);

        Course lowPerformingStudentsCourse =
                context.getBean("lowPerformingStudentsCourse", Course.class);
        Course highPerformingStudentsCourse =
                context.getBean("highPerformingStudentsCourse", Course.class);
        Course highestPerformingStudentCourse =
                context.getBean("highestPerformingStudentCourse", Course.class);
        Course lowestPerformingStudentCourse =
                context.getBean("lowestPerformingStudentCourse", Course.class);

        System.out.println("Low Performing Students Course:");
        lowPerformingStudentsCourse.displayAllStudents();

        System.out.println("\nHigh Performing Students Course:");
        highPerformingStudentsCourse.displayAllStudents();

        System.out.println("\nHighest Performing Student Course:");
        highestPerformingStudentCourse.displayAllStudents();

        System.out.println("\nLowest Performing Student Course:");
        lowestPerformingStudentCourse.displayAllStudents();
    }
}