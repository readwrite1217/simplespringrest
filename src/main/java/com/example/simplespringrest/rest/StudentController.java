package com.example.simplespringrest.rest;


import com.example.simplespringrest.exception.StudentNotFoundException;
import com.example.simplespringrest.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students;

    @PostConstruct
    public void setup() {
        students = new ArrayList<>();
        Student student = new Student(1, "john", "doe", true);
        Student student1 = new Student(2, "abc", "xyz", true);
        Student student2 = new Student(3, "name", "lastname", true);
        Student student3 = new Student(4, "hello", "world", true);
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    @GetMapping("/students/all")
    public List<Student> getAllStudents() {

        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") int id) throws StudentNotFoundException {
        Student st = null;
        if (id >= students.size() || id < 0) {
            throw new StudentNotFoundException("Not found");
        }
        for (Student s :
                students) {
            if (s.getId() == id) {
                st = s;
            }
        }
        return st;
    }

    @PostMapping("/students/update")
    public Student addStudent(@RequestBody Student student) {
        Student st = new Student(student.getId(), student.getFirstName(), student.getLastName(), student.isActive());
        students.add(st);
        return st;
    }

}
