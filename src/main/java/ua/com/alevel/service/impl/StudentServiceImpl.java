package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.CourseStudentDao;
import ua.com.alevel.dao.StudentDAO;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    private final CourseStudentDao courseStudentDao;

    public StudentServiceImpl(StudentDAO studentDAO, CourseStudentDao courseStudentDao) {
        this.studentDAO = studentDAO;
        this.courseStudentDao = courseStudentDao;
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
        courseStudentDao.deleteStudentRelations(id);
        studentDAO.delete(id);
    }

    @Override
    public Student findById(Long id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }
}
