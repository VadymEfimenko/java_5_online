package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.CourseDAO;
import ua.com.alevel.dao.StudentDAO;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.CourseService;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseDAO courseDAO;
    private final StudentDAO studentDAO;

    public CourseServiceImpl(CourseDAO courseDAO, StudentDAO studentDAO) {
        this.courseDAO = courseDAO;
        this.studentDAO = studentDAO;
    }

    @Override
    public void create(Course entity) {
        courseDAO.create(entity);
    }

    @Override
    public void update(Course entity) {
        courseDAO.update(entity);
    }

    @Override
    public void delete(Long id) {
        courseDAO.delete(id);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseDAO.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public List<Course> findAllCoursesByStudentId(Long studentId) {
        return courseDAO.findAllCoursesByStudentId(studentId);
    }

    @Override
    public List<Course> findUnrelatedCoursesByStudent(Long studentId) {
        return courseDAO.findUnrelatedCoursesByStudent(studentId);
    }

    @Override
    public void deleteCourseRelations(Long courseId) {
        List<Student> students = studentDAO.findAllStudentByCourseId(courseId);
        for (Student student : students) {
            if (courseDAO.findAllCoursesByStudentId(student.getId()).size()==1){
                studentDAO.deleteStudentRelations(student.getId());
                studentDAO.delete(student.getId());
            }
        }
        courseDAO.deleteCourseRelations(courseId);
    }

    @Override
    public void deleteOneCourseStudentRelation(Long courseId, Long studentId) {
        if (findAllCoursesByStudentId(studentId).size() == 1) {
            studentDAO.deleteStudentRelations(studentId);
            studentDAO.delete(studentId);
        }
        courseDAO.deleteOneCourseStudentRelation(courseId, studentId);
    }
}
