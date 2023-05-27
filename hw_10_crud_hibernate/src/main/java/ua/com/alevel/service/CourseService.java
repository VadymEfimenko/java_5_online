package ua.com.alevel.service;

import ua.com.alevel.entity.Course;

import java.util.List;

public interface CourseService extends BaseService<Course> {

    List<Course> findAllCoursesByStudentId(Long studentId);

    List<Course> findUnrelatedCoursesByStudent(Long studentId);

    void deleteCourseRelations(Long courseId);

    void deleteOneCourseStudentRelation(Long courseId, Long studentId);

}
