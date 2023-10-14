package com.studentsite.studentclass.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

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
    @OneToMany
    private List<Course> courses;

    public Student() {}

    public Student(String name, String email, String phone, List<Course> courses) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.courses = courses;
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
