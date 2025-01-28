package app.service;

import app.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student getStudentById(String id);
    List<Student> getAllStudent();
}
