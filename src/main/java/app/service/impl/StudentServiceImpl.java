package app.service.impl;

import app.pojo.Student;
import app.repository.StudentRepo;
import app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }
}
