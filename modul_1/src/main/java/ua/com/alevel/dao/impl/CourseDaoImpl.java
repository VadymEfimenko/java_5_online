package ua.com.alevel.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.CourseDAO;
import ua.com.alevel.entity.Course;

import java.util.List;

@Service
public class CourseDaoImpl implements CourseDAO {

    private final EntityStorage<Course> courseEntityStorage;

    public CourseDaoImpl(EntityStorage<Course> courseEntityStorage) {
        this.courseEntityStorage = courseEntityStorage;
    }

    @Override
    public void create(Course entity) {
        courseEntityStorage.add(entity, courseEntityStorage.getCourses());
    }

    @Override
    public void update(Course entity) {
        courseEntityStorage.update(entity, courseEntityStorage.getCourses());
    }

    @Override
    public void delete(Long id) {
        courseEntityStorage.delete(id, courseEntityStorage.getCourses());
    }

    @Override
    public Course findById(Long id) {
        return courseEntityStorage.findById(id, courseEntityStorage.getCourses());
    }

    @Override
    public List<Course> findAll() {
        return courseEntityStorage.getCourses();
    }

}
