package com.studentsite.studentclass.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String professor;
    @Column(nullable = false, updatable = false)
    private String courseCode;
    @OneToMany
    private List<Student> students;
    @ManyToAny
    private Map<Student, Integer> studentGrades;

    public Course() {}

    public Course(String name, String professor) {
        this.name = name;
        this.professor = professor;
        this.studentGrades = new HashMap<>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addGrade(Student student, Integer grade) {
        studentGrades.put(student, grade);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        studentGrades.remove(student);
    }

    public void removeGrade(Student student) {
        studentGrades.remove(student);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
