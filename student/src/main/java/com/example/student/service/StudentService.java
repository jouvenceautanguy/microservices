package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.model.School;
import com.example.student.model.StudentWithSchool;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplateService restTemplateService;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
    public StudentWithSchool getStudentWithSchool(String studentId) {
        Optional<Student> studentOpt = studentRepository.findById(Long.valueOf(studentId));
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            School school = restTemplateService.getPost(student.getSchoolId());
            return new StudentWithSchool(student, school);
        } else {
            return null;
        }
    }
}
