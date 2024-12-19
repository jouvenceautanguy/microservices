package com.example.student.model;

import com.example.student.entity.Student;

public class StudentWithSchool {
    private final Student student;
    private final School school;

    public StudentWithSchool(Student student, School school) {
        this.student = student;
        this.school = school;
    }

    // Getters
    public Student getStudent() { return student; }
    public School getSchool() { return school; }
}
