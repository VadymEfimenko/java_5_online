package ua.com.alevel.dao;

import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.CourseStudent;
import ua.com.alevel.entity.Student;

import java.util.List;

public interface CourseStudentDao extends BaseDAO<CourseStudent> {

    List<Student> findAllStudentByCourseId(Long courseId);
    List<Course> findAllCoursesByStudentId(Long studentId);

    void deleteCourseRelations(Long courseId);

    void deleteStudentRelations(Long studentId);

    void deleteOneCourseStudentRelation(Long courseId, Long studentId);

    List<Course> findUnrelatedCoursesByStudent(Long studentId);

    List<Student> findUnrelatedStudentsByCourse(Long courseId);
}
