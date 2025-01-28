package app.controller;

import app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    private final StudentService ss;

    @Autowired
    public StudentController(StudentService ss) {
        this.ss = ss;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(ss.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping("/student")
    public ResponseEntity<?> getAllStudent() {
        return new ResponseEntity<>(ss.getAllStudent(), HttpStatus.OK);
    }
}
