package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.CourseDAO;
import ua.com.alevel.dao.CourseStudentDao;
import ua.com.alevel.entity.Course;
import ua.com.alevel.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseDAO courseDAO;

    private final CourseStudentDao courseStudentDao;
    public CourseServiceImpl(CourseDAO courseDAO, CourseStudentDao courseStudentDao) {
        this.courseDAO = courseDAO;

        this.courseStudentDao = courseStudentDao;
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
        courseStudentDao.deleteCourseRelations(id);
        courseDAO.delete(id);
    }

    @Override
    public Course findById(Long id) {
        return courseDAO.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }
}
