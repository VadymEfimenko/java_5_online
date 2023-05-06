package ua.com.alevel.dao;

import ua.com.alevel.entity.Student;

import java.util.List;

public interface StudentDAO extends BaseDAO<Student> {

    List<Student> findAllStudentByCourseId(Long courseId);

    List<Student> findUnrelatedStudentsByCourse(Long courseId);

    void deleteStudentRelations(Long studentId);

    void createCourseStudentRelation(Long courseId, Long studentId);

    Long findLastCreatedStudent();
}
