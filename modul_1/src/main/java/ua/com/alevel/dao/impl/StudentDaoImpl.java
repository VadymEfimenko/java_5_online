package ua.com.alevel.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.StudentDAO;
import ua.com.alevel.entity.Student;

import java.util.List;

@Service
public class StudentDaoImpl implements StudentDAO {
    private final EntityStorage<Student> entityStorage;

    public StudentDaoImpl(EntityStorage<Student> entityStorage) {
        this.entityStorage = entityStorage;
    }

    @Override
    public void create(Student entity) {
        entityStorage.add(entity, entityStorage.getStudents());
    }

    @Override
    public void update(Student entity) {
        entityStorage.update(entity, entityStorage.getStudents());
    }

    @Override
    public void delete(Long id) {
        entityStorage.delete(id, entityStorage.getStudents());
    }

    @Override
    public Student findById(Long id) {
        return entityStorage.findById(id, entityStorage.getStudents());
    }

    @Override
    public List<Student> findAll() {
        return entityStorage.getStudents();
    }
}
