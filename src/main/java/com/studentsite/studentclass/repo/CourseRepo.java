package com.studentsite.studentclass.repo;

import com.studentsite.studentclass.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    void deleteCourseById(Long id);

    Optional<Course> findCourseById(Long id);
}
