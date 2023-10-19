package com.studentsite.studentclass.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @Column(nullable = false, updatable = false)
    private String studentCode;
    @ElementCollection
    private List<Integer> courseIds;
    @ElementCollection
    private Map<Integer, Integer> courseGrades;

    public Student() {
        this.courseIds = new ArrayList<>();
        this.courseGrades = new HashMap<>();
    }

    public Student(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.courseIds = new ArrayList<>();
        this.courseGrades = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + "\'" +
                "name='" + name + "\'" +
                "email='" + email + "\'" +
                "phone='" + phone + "\'" +
                "}";
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public List<Integer> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Integer> courseIds) {
        this.courseIds = courseIds;
    }

    public Map<Integer, Integer> getCourseGrades() {
        return this.courseGrades;
    }
    public void setCourseGrades(Map<Integer, Integer> courseGrades) {
        this.courseGrades = courseGrades;
    }

    public void addGrade(Integer courseId, Integer grade) {
        courseGrades.put(courseId, grade);
    }

    public void removeCourse(Integer courseId) {
        courseIds.remove(courseId);
        courseGrades.remove(courseId);
    }

    public void removeGrade(Integer courseId) {
        courseGrades.remove(courseId);
    }
}
