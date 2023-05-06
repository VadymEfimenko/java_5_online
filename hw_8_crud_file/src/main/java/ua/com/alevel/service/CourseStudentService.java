package ua.com.alevel.service;

import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.CourseStudent;
import ua.com.alevel.entity.Student;

import java.util.List;

public interface CourseStudentService extends BaseService<CourseStudent> {

    List<Course> findAllCoursesByStudentId(Long studentId);

    List<Course> findUnrelatedCoursesByStudent(Long studentId);

    void deleteCourseStudentRelation(Long courseId, Long studentId);

    List<Student> findAllStudentByCourseId(Long courseId);

    List<Student> findUnrelatedStudentsByCourse(Long courseId);
}
