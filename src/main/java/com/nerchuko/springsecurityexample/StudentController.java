package com.nerchuko.springsecurityexample;

import com.nerchuko.springsecurityexample.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students=new ArrayList<>(List.of(new Student(1,"tharun",100),new Student(2,"varun",90),new Student(3,"Rajesh",80)));
    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return students;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student)
    {
        students.add(student);
        return student;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request)
    {
        return  (CsrfToken) request.getAttribute("_csrf");

    }
}
