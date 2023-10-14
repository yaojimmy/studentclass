package com.studentsite.studentclass.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.io.Serializable;
import java.util.Map;

@Entity
public class Course implements Serializable {
    private Long id;
    private String name;
    private String professor;
    @Column(nullable = false, updatable = false)
    private String courseCode;
    @ManyToAny
    private Map<Student, Integer> studentGrades;

    public Course() {}

    public Course(Long id, String name, String professor, Map<Student, Integer> studentGrades) {
        this.id = id;
        this.name = name;
        this.professor = professor;
        this.studentGrades = studentGrades;
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
        studentGrades.put(student, 0);
    }

    public void changeGrade(Student student, Integer grade) {
        studentGrades.put(student, grade);
    }

    public void removeStudent(Student student) {
        studentGrades.remove(student);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
