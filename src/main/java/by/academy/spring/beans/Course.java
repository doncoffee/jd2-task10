package by.academy.spring.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String name;
    private List<Student> students;

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println("Student: " + student.getFirstName() + " "
                    + student.getLastName());
        }
    }
}
