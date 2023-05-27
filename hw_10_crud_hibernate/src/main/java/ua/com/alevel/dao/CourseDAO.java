package ua.com.alevel.dao;

import ua.com.alevel.entity.Course;

import java.util.List;

public interface CourseDAO extends BaseDAO<Course> {

    List<Course> findAllCoursesByStudentId(Long studentId);

    List<Course> findUnrelatedCoursesByStudent(Long studentId);

    void deleteCourseRelations(Long courseId);

    void deleteOneCourseStudentRelation(Long courseId, Long studentId);

}
