package com.studentsite.studentclass.service;

import com.studentsite.studentclass.exception.UserNotFoundException;
import com.studentsite.studentclass.model.Student;
import com.studentsite.studentclass.repo.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student addStudent(Student student) {
        student.setStudentCode(UUID.randomUUID().toString());
        return studentRepo.save(student);
    }

    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student findStudentById(Long id) {
        return studentRepo.findStudentById(id)
                .orElseThrow(() -> new UserNotFoundException("User By id " + id + " was not found"));
    }

    @Transactional
    public void deleteStudent(Long id) {
        studentRepo.deleteStudentById(id);
    }
}
