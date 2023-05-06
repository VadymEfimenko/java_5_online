package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.StudentDAO;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void create(Student entity) {
        studentDAO.create(entity);
    }

    @Override
    public void update(Student entity) {
        studentDAO.update(entity);
    }

    @Override
    public void delete(Long id) {
        studentDAO.delete(id);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> findAllStudentByCourseId(Long courseId) {
        return studentDAO.findAllStudentByCourseId(courseId);
    }

    @Override
    public List<Student> findUnrelatedStudentsByCourse(Long courseId) {
        return studentDAO.findUnrelatedStudentsByCourse(courseId);
    }

    @Override
    public void deleteStudentRelations(Long studentId) {
        studentDAO.deleteStudentRelations(studentId);
    }

    @Override
    public void createCourseStudentRelation(Long courseId, Long studentId) {
        studentDAO.createCourseStudentRelation(courseId, studentId);
    }

    @Override
    public Long findLastCreatedStudent() {
        return studentDAO.findLastCreatedStudent();
    }
}
