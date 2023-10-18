package com.studentsite.studentclass.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

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
    @ElementCollection
    private Set<Integer> students;
    @ElementCollection
    @CollectionTable(name = "student_grade_mapping",
            joinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "student")
    @Column(name = "grade")
    private Map<Integer, Integer> studentGrades;

    public Course() {
        this.students = new HashSet<>();
        this.studentGrades = new HashMap<>();
    }

    public Course(String name, String professor) {
        this.name = name;
        this.professor = professor;
        this.students = new HashSet<>();
        this.studentGrades = new HashMap<>();
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void addStudent(Integer studentId) {
        students.add(studentId);
    }

    public void addGrade(Integer studentId, Integer grade) {
        studentGrades.put(studentId, grade);
    }

    public void removeStudent(Integer studentId) {
        students.remove(studentId);
        studentGrades.remove(studentId);
    }

    public void removeGrade(Integer studentId) {
        studentGrades.remove(studentId);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
