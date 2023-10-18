package com.studentsite.studentclass.service;

import com.studentsite.studentclass.exception.CourseNotFoundException;
import com.studentsite.studentclass.model.Course;
import com.studentsite.studentclass.repo.CourseRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService {
    private final CourseRepo courseRepo;

    @Autowired
    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public Course addCourse(Course course) {
        course.setCourseCode(UUID.randomUUID().toString());
        return courseRepo.save(course);
    }

    public List<Course> findAllCourses() {
        return courseRepo.findAll();
    }

    public Course updateCourse(Course course) {
        return courseRepo.save(course);
    }

    public Course findCourseById(Long id) {
        return courseRepo.findCourseById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course By id " + id + " was not found"));
    }

    @Transactional
    public void deleteCourse(Long id) {
        courseRepo.deleteCourseById(id);
    }
}
