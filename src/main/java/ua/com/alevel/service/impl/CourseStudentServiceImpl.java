package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.CourseStudentDao;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.CourseStudent;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.CourseStudentService;

import java.util.List;

@Service
public class CourseStudentServiceImpl implements CourseStudentService {

    private final CourseStudentDao courseStudentDao;

    public CourseStudentServiceImpl(CourseStudentDao courseStudentDao) {
        this.courseStudentDao = courseStudentDao;
    }

    @Override
    public void create(CourseStudent entity) {
        courseStudentDao.create(entity);
    }

    @Override
    public void update(CourseStudent entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CourseStudent findById(Long id) {
        return null;
    }

    @Override
    public List<CourseStudent> findAll() {
        return null;
    }

    @Override
    public List<Student> findAllStudentByCourseId(Long courseId) {
        return courseStudentDao.findAllStudentByCourseId(courseId);
    }

    @Override
    public List<Course> findAllCoursesByStudentId(Long studentId) {
        return courseStudentDao.findAllCoursesByStudentId(studentId);
    }

    @Override
    public void deleteCourseStudentRelation(Long courseId, Long studentId) {
        courseStudentDao.deleteOneCourseStudentRelation(courseId, studentId);
    }

    @Override
    public List<Course> findUnrelatedCoursesByStudent(Long studentId) {
        return courseStudentDao.findUnrelatedCoursesByStudent(studentId);
    }

    @Override
    public List<Student> findUnrelatedStudentsByCourse(Long courseId) {
        return courseStudentDao.findUnrelatedStudentsByCourse(courseId);
    }
}
